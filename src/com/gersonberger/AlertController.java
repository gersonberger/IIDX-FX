package com.gersonberger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEvent;
import javafx.stage.Stage;


public class AlertController {

    private Stage dialogStage;

    @FXML
    private VBox labelVbox;

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
        Label label = new Label(param.getData().toString());
        label.setWrapText(true);
        labelVbox.getChildren().add(label);
    }

    public void setDialogStage(Stage dialogStage, String title, String... messages) {
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
        for (String message : messages) {
            Label label = new Label(message);
            label.setWrapText(true);
            labelVbox.getChildren().add(label);
        }
    }

    @FXML
    private void handleClose(){
        dialogStage.close();
    }

}
