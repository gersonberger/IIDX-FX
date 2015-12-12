package com.gersonberger;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {

    @FXML
    private ImageView logoImageView;
    @FXML
    private Label nameLabel;
    @FXML
    private Label programVersionLabel;
    @FXML
    private Label programDateLabel;
    @FXML
    private Label OSNameLabel;
    @FXML
    private Label OSVersionLabel;

    private Stage dialogStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Main.programTheme.equals(Main.THEMELIGHT)) logoImageView.setImage(new Image(getClass().getResource("/img/logo.png").toString()));
        else logoImageView.setImage(new Image(getClass().getResource("/img/logo_dark.png").toString()));

        nameLabel.setText(Main.PROGRAMNAME + " (" + System.getProperty("os.arch") + ")");
        programVersionLabel.setText(Main.PROGRAMVERSION);
        programDateLabel.setText(Main.PROGRAMDATE);
        OSNameLabel.setText(System.getProperty("os.name"));
        OSVersionLabel.setText(System.getProperty("os.version"));
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        if (Main.programTheme.equals(Main.THEMEDARK)) {
            dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/dark.css").toExternalForm());
        }
    }

    public void handleClose() {
        dialogStage.close();
    }

}
