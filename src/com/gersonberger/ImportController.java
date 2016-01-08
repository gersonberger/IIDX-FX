package com.gersonberger;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class ImportController implements Initializable {

    private static final int NOPROFILE = -21;
    private static final int CHUNKERROR = -20;
    public static final int ERROR = -1;
    public static final int ABORTED = 0;
    public static final int SUCCESS = 1;

    private static final String[] VERSIONS = {Style.OMNIMIX, Style.PENDUALFULL, Style.SPADAFULL, Style.TRICOROFULL,
            Style.LINCLEFULL, Style.RESORTANTHEMFULL, Style.SIRIUSFULL};

    private static final String PSUNLOGIN = "HIDDEN";
    private static final String PSUNHOME = "HIDDEN";
    private static final String PSUNR1 = "HIDDEN";
    private static final String PSUNR2 = "HIDDEN";
    private static final String PSUNR3 = "HIDDEN";

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox<String> versionBox;
    @FXML
    private Label infoLabel;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Button importButton;

    private Stage dialogStage;

    private BasicCookieStore cookieStore = new BasicCookieStore();
    private CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

    private int status = ABORTED;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        versionBox.getItems().addAll(VERSIONS);
        versionBox.setValue(Style.OMNIMIX);
        Platform.runLater(() -> {
            passwordField.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) handleImport();
            });
            versionBox.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) handleImport();
            });
        });
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        if (Main.programTheme.equals(Main.THEMEDARK)) {
            dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/dark.css").toExternalForm());
        }
    }

    public int getStatus() {
        return status;
    }

    public void handleImport() {
        if (validate()){
            loginStart();
            new Thread(() -> {
                try {
                    //psun login (store cookie)
                    if (psunLogin(usernameField.getText(), passwordField.getText())) {
                        loginSuccess();

                        //get userid
                        String userID = getUserID();
                        if (userID != null) {

                            //fetch data
                            String data = psunGetScoreData(userID);
                            if (data != null) {

                                //convert data
                                List<ScoreEntry> scoreEntryList = readscores(data);

                                if (status != NOPROFILE) {
                                    //save data to file
                                    saveScoresToFile(scoreEntryList);

                                    //done
                                    fetchingSuccess();
                                    status = SUCCESS;

                                } else {
                                    status = ERROR;
                                    Thread.sleep(500);
                                    noProfile();
                                }
                            } else {
                                if (status != CHUNKERROR) fetchingFailed();
                                status = ERROR;
                            }
                        } else {
                            status = ERROR;
                            idFailed();
                        }
                    } else {
                        status = ERROR;
                        loginFailed();
                    }
                } catch (Exception e) {
                    status = ERROR;
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void loginStart() {
        Platform.runLater(() -> {
            System.out.print(Main.getTime() + " Beginning import...");
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            versionBox.setDisable(true);
            importButton.setDisable(true);
            infoLabel.setTextFill(Objects.equals(Main.programTheme, Main.THEMELIGHT) ? Color.BLACK : Color.WHITE);
            infoLabel.setText("Logging in...");
            FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(200), infoLabel);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.5);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(200), progressIndicator);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(1);
            new Thread(() -> {
                fadeTransition1.play();
                fadeTransition2.play();
            }).start();
        });
    }

    private void loginFailed() {
        Platform.runLater(() -> {
            System.out.print(Main.getTime() + " Login failed!");
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Login failed!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
                versionBox.setDisable(false);
                importButton.setDisable(false);
            }));
            new Thread(transition::play).start();
        });
    }

    private void loginSuccess() {
        Platform.runLater(() -> {
            FadeTransition transition1 = new FadeTransition(Duration.millis(400), infoLabel);
            transition1.setFromValue(0.5);
            transition1.setToValue(0);
            transition1.setOnFinished(event -> Platform.runLater(() -> {
                infoLabel.setTextFill(Objects.equals(Main.programTheme, Main.THEMELIGHT) ? Color.BLACK : Color.WHITE);
                infoLabel.setText("Downloading data...");
                FadeTransition transition2 = new FadeTransition(Duration.millis(400), infoLabel);
                transition2.setFromValue(0);
                transition2.setToValue(0.5);
                transition2.play();
            }));
            new Thread(transition1::play).start();
        });
    }

    private void noProfile() {
        Platform.runLater(() -> {
            System.out.print(Main.getTime() + " No profile found!");
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("No profile found!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
                versionBox.setDisable(false);
                importButton.setDisable(false);
            }));
            new Thread(transition::play).start();
        });
    }

    private void fetchingFailed() {
        Platform.runLater(() -> {
            System.out.println(Main.getTime() + " Data download failed!");
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Data download failed!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
                versionBox.setDisable(false);
                importButton.setDisable(false);
            }));
            new Thread(transition::play).start();
        });
    }

    private void idFailed() {
        Platform.runLater(() -> {
            System.out.print(Main.getTime() + " Retrieving player-ID failed!");
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Retrieving player-ID failed!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
                versionBox.setDisable(false);
                importButton.setDisable(false);
            }));
            new Thread(transition::play).start();
        });
    }

    private void profileError() {
        status = CHUNKERROR;
        Platform.runLater(() -> {
            System.out.print(Main.getTime() + " Invalid Psun profile! (incomplete chunk encoding)");
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Invalid psun records page!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
                versionBox.setDisable(false);
                importButton.setDisable(false);
            }));
            new Thread(transition::play).start();
        });
    }

    private void fetchingSuccess() {
        Platform.runLater(() -> {
            FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(1500), progressIndicator);
            fadeTransition4.setFromValue(1);
            fadeTransition4.setToValue(0);
            FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(1500), infoLabel);
            fadeTransition3.setFromValue(0.5);
            fadeTransition3.setToValue(0);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(200), infoLabel);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(0.5);
            fadeTransition2.setOnFinished(event -> {
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fadeTransition3.play();
                fadeTransition4.play();
            });
            FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(200), infoLabel);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.setOnFinished(event2 -> {
                progressIndicator.setProgress(1);
                progressIndicator.setMaxHeight(40);
                importButton.setText("Close");
                infoLabel.setTextFill(Objects.equals(Main.programTheme, Main.THEMELIGHT) ? Color.BLACK : Color.WHITE);
                infoLabel.setText("Importing data successful");
                importButton.setOnAction(event3 -> dialogStage.close());
                importButton.setDisable(false);
                fadeTransition2.play();
            });
            new Thread(() -> {
                Platform.runLater(fadeTransition1::play);
            }).start();
        });
    }

    private boolean validate() {
        boolean rtnval = true;
        if (usernameField.getText().equals("")) {
            usernameField.getStyleClass().add("error");
            rtnval = false;
        } else {
            usernameField.getStyleClass().remove("error");
        }
        if (passwordField.getText().equals("")) {
            passwordField.getStyleClass().add("error");
            rtnval = false;
        } else {
            passwordField.getStyleClass().remove("error");
        }
        return rtnval;
    }

    private boolean psunLogin(String username, String password) {
        try {
            HttpUriRequest login = RequestBuilder.post().setUri(new URI(PSUNLOGIN))
                    .addParameter("username", username).addParameter("password", password).build();

            System.out.println("\n" + Main.getTime() + " Logging in to Programmed Sun...");
            try (CloseableHttpResponse response = httpclient.execute(login)) {

                HttpEntity entity = response.getEntity();

                System.out.println(Main.getTime() + " Response from Server: " + response.getStatusLine());
                EntityUtils.consume(entity);

                System.out.print(Main.getTime() + " Post logon cookie: ");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                    return false;
                }
                else for (Cookie cookie : cookies) System.out.println(cookie.toString());
                System.out.println(Main.getTime() + " Login successful");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String getUserID() {
        String data = null;
        String userID = null;
        HttpGet httpget = new HttpGet(PSUNHOME);
        System.out.println(Main.getTime() + " Getting player-ID...");
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            HttpEntity entity = response.getEntity();
            System.out.println(Main.getTime() + " Response from Server: " + response.getStatusLine());
            data = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {
            for (String line : data.split("\n")) {
                if (line.contains("<a class=\"\" href=\"/users/") && line.contains("/options\">Your account</a>")) {
                    line = line.trim();
                    int i = line.indexOf("href=\"/") + 13;
                    userID = line.substring(i, i + 9);
                    System.out.println(Main.getTime() + " Player-ID: " + userID);
                }
            }
        }
        return userID;
    }

    private String psunGetScoreData(String userID) {
        if (userID == null) return null;
        HttpGet httpget = new HttpGet(PSUNR1 + Style.styleFullToInt(versionBox.getValue()) + PSUNR2 + userID + PSUNR3);
        System.out.println(Main.getTime() + " Downloading data...");
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            HttpEntity entity = response.getEntity();
            System.out.println(Main.getTime() + " Response from Server: " + response.getStatusLine());
            String data = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return data;
        } catch (ConnectionClosedException e) {
            e.printStackTrace();
            profileError();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<ScoreEntry> readscores(String psundata) {
        final int version = Style.styleFullToInt(versionBox.getValue());
        final int offset = version == 0 ? 0 : 1;
        List<ScoreEntry> scoreList = new ArrayList<>();
        if (psundata.contains("<div class=\"ypanel\">You do not have a profile for this game version. Please \n" +
                "choose a different  version from the dropdown above.</div>")) {
            status = NOPROFILE;
            return null;
        }
        else {
            String songid = null;
            String diff = null;
            String clear = null;
            String miss;
            String percent = null;
            for (String line : psundata.split("\n")) {
                if (line.contains("<div>Failed</div>") ||
                        line.contains("<div>Assist Clear</div>") ||
                        line.contains("<div>Easy Clear</div>") ||
                        line.contains("<div>Clear</div>") ||
                        line.contains("<div>Hard Clear</div>") ||
                        line.contains("<div>Ex Hard Clear</div>") ||
                        line.contains("<div>Full Combo</div>")) {
                    clear = line.trim().substring(5, line.trim().indexOf("</div>"));
                }
                else if (line.contains("<a class=\"\" href=\"/iidx/" + version + "/music/")) {
                    songid = line.trim().substring(32 + offset, 37 + offset);
                    if (songid.charAt(4) == '/') songid = songid.substring(0,4);
                    switch (line.trim().substring(33 + songid.length() + offset, 34 + songid.length() + offset)) {
                        case "n":
                            diff = Difficulty.NORMAL;
                            break;
                        case "h":
                            diff = Difficulty.HYPER;
                            break;
                        case "a":
                            diff = Difficulty.ANOTHER;
                            break;
                    }
                }
                else if (line.contains("[")) {
                    percent = line.trim().substring(1,6);
                    if (percent.charAt(4) == '%') {
                        percent = percent.substring(0,4);
                    }
                }
                else if (line.contains("Misses</div>")) {
                    miss = line.trim().substring(5, line.trim().indexOf("</div>"));
                    if (clear == null) clear = Clear.NOPLAY;
                    scoreList.add(createScoreEntry(songid, diff, clear, miss, percent));
                    clear = null;
                }
            }
            return scoreList;
        }
    }

    private ScoreEntry createScoreEntry(String songidstr, String diffstr, String clearstr, String missstr, String percentstr) {
        if (songidstr == null || diffstr == null || clearstr == null || missstr == null || percentstr == null) {
            System.out.println("id: " + songidstr + " | diff: " + diffstr + " | clear: " + clearstr + " | miss: " + missstr + " | percent: " + percentstr);
            return null;
        }
        int songid = Integer.parseInt(songidstr);
        int diff = Difficulty.difficultyToInt(diffstr);
        int clear;
        switch (clearstr) {
            case Clear.FAILED:
                clear = Clear.FAILED_INT;
                break;
            case Clear.ASSISTCLEAR:
                clear = Clear.ASSISTCLEAR_INT;
                break;
            case Clear.EASYCLEAR:
                clear = Clear.EASYCLEAR_INT;
                break;
            case Clear.CLEAR:
                clear = Clear.CLEAR_INT;
                break;
            case Clear.HARDCLEAR:
                clear = Clear.HARDCLEAR_INT;
                break;
            case Clear.EXHARDCLEAR:
                clear = Clear.EXHARDCLEAR_INT;
                break;
            case Clear.FULLCOMBO:
                clear = Clear.FULLCOMBO_INT;
                break;
            default:
                clear = Clear.NOPLAY_INT;
                break;
        }
        int miss = -2;
        try {
            //some entries show "N/A Misses"
            if (missstr.startsWith("N")) miss = -1;
            else miss = Integer.parseInt(missstr.substring(0, missstr.length() - 7));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(songidstr + "\n" + diffstr + "\n" + clearstr + "\n" + missstr + "\n" + percentstr);
        }

        double percent = Double.parseDouble(percentstr);

        return new ScoreEntry(songid, diff, clear, miss, percent);
    }

    private void saveScoresToFile(List<ScoreEntry> scoreEntryList) {
        String path = Main.LOCALDIR + Main.SEPARATOR + "scores.txt";
        File file = new File(path);
        try {
            PrintWriter printWriter = new PrintWriter(file.getPath());
            for (ScoreEntry entry : scoreEntryList) {
                if (entry != null) {
                    printWriter.println(entry.songid + "," + entry.diff + "," + entry.clearstatus + "," + entry.miss + "," + entry.grade + "," + entry.percent);
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}