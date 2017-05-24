package com.gersonberger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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
        if (Main.programTheme.equals(Main.THEMEDARK)) logoImageView.setImage(new Image(getClass().getResource("/img/logo_dark.png").toString()));
        else logoImageView.setImage(new Image(getClass().getResource("/img/logo.png").toString()));

        nameLabel.setText(Main.PROGRAMNAME + " (" + System.getProperty("os.arch") + ")");
        programVersionLabel.setText(Main.PROGRAMVERSION);
        programDateLabel.setText(Main.PROGRAMDATE);
        OSNameLabel.setText(System.getProperty("os.name"));
        OSVersionLabel.setText(System.getProperty("os.version"));
    }

    public void setDialogStage(Stage dialogStage) {
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
    }

    public void handleClose() {
        dialogStage.close();
    }

}
