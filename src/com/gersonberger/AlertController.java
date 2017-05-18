package com.gersonberger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.WebEvent;
import javafx.stage.Stage;


public class AlertController {

    private Stage dialogStage;

    @FXML
    private Label alertLabel;

    public void setDialogStage(Stage dialogStage, WebEvent param) {
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
        alertLabel.setText(param.getData().toString());
    }

    public void setDialogStage(Stage dialogStage, String title, String message) {
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
        dialogStage.setTitle(title);
        alertLabel.setText(message);
    }

    @FXML
    private void handleClose(){
        dialogStage.close();
    }

}
