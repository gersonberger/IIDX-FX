package com.gersonberger;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.web.PromptData;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PromptController implements Initializable {

    static final int SUCCESS = 1;
    static final int ABORT = -1;

    @FXML
    private Label promptLabel;
    @FXML
    private TextField promptTextField;

    private Stage dialogStage;
    private int status = ABORT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setDialogStage(Stage dialogStage, PromptData param) {
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
        promptLabel.setText(param.getMessage());
        promptTextField.setText(param.getDefaultValue());
        promptTextField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) handleOk();
        });
    }

    int getStatus() {
        return status;
    }

    String getValue() {
        return promptTextField.getText();
    }

    @FXML
    private void handleOk() {
        status = SUCCESS;
        dialogStage.close();
    }

    @FXML
    private void handleClose() {
        status = ABORT;
        dialogStage.close();
    }

}
