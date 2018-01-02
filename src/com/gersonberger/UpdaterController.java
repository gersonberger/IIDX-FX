package com.gersonberger;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;


public class UpdaterController {

    @FXML
    private Label labelCurrentVersion;
    @FXML
    private Label labelNewVersion;
    @FXML
    private Hyperlink hyperlinkUrl;
    @FXML
    public Label labelSize;
    @FXML
    private Button buttonDownload;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonClose;

    private Stage dialogStage;
    private File newApplication = null;
    private int size = 0;
    private int sizeCurrent = 0;
    private long lastupdated = System.currentTimeMillis();

    public void setDialogStage(Stage dialogStage, String newversion, String url, int size) {
        this.dialogStage = dialogStage;
        switch (Main.programTheme) {
            case Main.THEMELIGHT:
                dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMELIGHT).toExternalForm());
                break;
            case Main.THEMEDARK:
                dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMEDARK).toExternalForm());
                break;
            case Main.THEMENANAHIRA:
                dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMENANAHIRA).toExternalForm());
                break;
            default:
                dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMELIGHT).toExternalForm());
                break;
        }

        labelCurrentVersion.setText(Main.PROGRAMVERSION);

        labelNewVersion.setText(newversion);

        hyperlinkUrl.setText(url);
        hyperlinkUrl.setPadding(new Insets(0));

        this.size = size;
        labelSize.setText(String.valueOf(round(size / 1024d / 1024d) + " MB"));

        buttonDownload.requestFocus();
    }


    @FXML
    private void handleDownload() {

        //get current executable path
        String fileloc = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if (Main.getOS() == Main.LINUX) {
            fileloc = fileloc.substring(0, fileloc.lastIndexOf("/") + 1);
        } else if (Main.getOS() == Main.WINDOWS) {
            fileloc = fileloc.substring(1, fileloc.lastIndexOf("/"));
        }

        FileChooser fileChooser = new FileChooser();

        //set init directory and filename
        File initialDirectory = new File(fileloc);
        if (initialDirectory.isDirectory()) {
            fileChooser.setInitialDirectory(initialDirectory);
        }
        fileChooser.setInitialFileName(Main.PROGRAMNAME + " " + labelNewVersion.getText() + ".jar");

        File file = fileChooser.showSaveDialog(dialogStage.getScene().getWindow());

        if (file != null) {
            buttonDownload.setDisable(true);
            progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
            buttonClose.setDisable(true);

            new Thread(() -> {
                try {
                    URL url = new URL(hyperlinkUrl.getText());
                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                    int responseCode = httpConn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        log(Module.UPDATER, "content-type: " + httpConn.getContentType());

                        //note: can not update progress to progressbar since s-ul.eu
                        //doesn't provide content-length in http-header

                        //resolved by putting filesize in metafile

                        InputStream inputStream = httpConn.getInputStream();
                        FileOutputStream outputStream = new FileOutputStream(file.getPath());

                        int bytesRead;
                        byte[] buffer = new byte[4096];
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            sizeCurrent += bytesRead;
                            outputStream.write(buffer, 0, bytesRead);
                            updateProgress((double)sizeCurrent / size);
                        }

                        outputStream.close();
                        inputStream.close();

                        Platform.runLater(() -> {
                            progressBar.setProgress(1);
                            buttonClose.setDisable(false);
                            buttonStart.setDisable(false);
                        });

                        newApplication = file;

                        log(Module.UPDATER, "new version downloaded to: " + file.getPath());
                    }
                    //else handle httpcode
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private void updateProgress(double progress) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastupdated > 17) {
            Platform.runLater(() -> progressBar.setProgress(progress));
            lastupdated = currentTime;
        }
    }

    @FXML
    private void handleUrl() {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URI(hyperlinkUrl.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void changelog() {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URI("https://bemaniso.ws/forums.php?action=viewthread&threadid=45682"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void startApplication() {
        final String javaBin = System.getProperty("java.home") + Main.SEPARATOR + "bin" + Main.SEPARATOR + "java";

        if (newApplication != null && newApplication.getName().endsWith(".jar")) {
            final ArrayList<String> command = new ArrayList<>();
            command.add(javaBin);
            command.add("-jar");
            command.add(newApplication.getPath());

            final ProcessBuilder processBuilder = new ProcessBuilder(command);
            try {
                processBuilder.start();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    private void log(String module, String message) {
        Main.log(module, message);
    }

}
