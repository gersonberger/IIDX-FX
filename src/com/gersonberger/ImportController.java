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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ImportController implements Initializable {

    public static final int ERROR = -1;
    public static final int ABORTED = 0;
    public static final int SUCCESS = 1;

    private static final String PSUNLOGIN = "HIDDEN";
    private static final String PSUNHOME = "HIDDEN";
    private static final String PSUNR1 = "HIDDEN";
    private static final String PSUNR2 = "HIDDEN";

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
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
        Platform.runLater(() -> passwordField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) handleImport();
        }));
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

                                //save data to file
                                saveScoresToFile(scoreEntryList);

                                fetchingSuccess();
                                status = SUCCESS;
                            } else {
                                status = ERROR;
                                fetchingFailed();
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
            usernameField.setDisable(true);
            passwordField.setDisable(true);
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
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Login failed!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
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

    private void fetchingFailed() {
        Platform.runLater(() -> {
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Data download failed!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
                importButton.setDisable(false);
            }));
            new Thread(transition::play).start();
        });
    }

    private void idFailed() {
        Platform.runLater(() -> {
            infoLabel.setTextFill(Color.RED);
            infoLabel.setText("Retrieving player-ID failed!");
            FadeTransition transition = new FadeTransition(Duration.millis(200), progressIndicator);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.setOnFinished(event -> Platform.runLater(() -> {
                usernameField.setDisable(false);
                passwordField.setDisable(false);
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

            System.out.println("\n" + getTime() + " Logging in to Programmed Sun...");
            try (CloseableHttpResponse response = httpclient.execute(login)) {

                HttpEntity entity = response.getEntity();

                System.out.println(getTime() + " Response from Server: " + response.getStatusLine());
                EntityUtils.consume(entity);

                System.out.print(getTime() + " Post logon cookie: ");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                    return false;
                }
                else for (Cookie cookie : cookies) System.out.println(cookie.toString());
                System.out.println(getTime() + " Login successful");
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
        System.out.println(getTime() + " Getting player-ID...");
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            HttpEntity entity = response.getEntity();
            System.out.println(getTime() + " Response from Server: " + response.getStatusLine());
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
                    System.out.println(getTime() + " Player-ID: " + userID);
                }
            }
        }
        return userID;
    }

    private String psunGetScoreData(String userID) {
        if (userID == null) return null;
        HttpGet httpget = new HttpGet(PSUNR1 + userID + PSUNR2);
        System.out.println(getTime() + " Downloading data...");
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            HttpEntity entity = response.getEntity();
            System.out.println(getTime() + " Response from Server: " + response.getStatusLine());
            String data = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<ScoreEntry> readscores(String psundata) {
        List<ScoreEntry> scoreList = new ArrayList<>();
        psundata.substring(psundata.indexOf("<table class=\"grid\">"));
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
            if (line.contains("<a class=\"\" href=\"/iidx/0/music/")) {
                songid = line.trim().substring(32, 37);
                if (songid.charAt(4) == '/') songid = songid.substring(0,4);
                switch (line.trim().substring(33 + songid.length(), 34 + songid.length())) {
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
            if (line.contains("[")) {
                percent = line.trim().substring(1,6);
                if (percent.charAt(4) == '%') {
                    percent = percent.substring(0,4);
                }
            }
            if (line.contains("Misses</div>")) {
                miss = line.trim().substring(5, line.trim().indexOf("</div>"));
                scoreList.add(createScoreEntry(songid, diff, clear, miss, percent));
                clear = null;
            }
        }
        return scoreList;
    }

    private ScoreEntry createScoreEntry(String songidstr, String diffstr, String clearstr, String missstr, String percentstr) {
        if (clearstr == null) clearstr = Clear.NOPLAY;
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

    private String getTime() {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        return formatter.format(date);
    }

    private void saveScoresToFile(List<ScoreEntry> scoreEntryList) {
        String path = null;
        switch (Main.os) {
            case Main.WINDOWS:
                path = System.getProperty("user.home") + "\\AppData\\Roaming\\IIDX-FX\\scores.txt";
                break;
            case Main.LINUX:
                path = System.getProperty("user.home") + "/.IIDX-FX/scores.txt";
                break;
        }
        if (path != null) {
            File file = new File(path);
            try {
                PrintWriter printWriter = new PrintWriter(file.getPath());
                for (ScoreEntry entry : scoreEntryList) {
                    printWriter.println(entry.songid + "," + entry.diff + "," + entry.clearstatus + "," + entry.miss + "," + entry.grade + "," + entry.percent);
                }
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}