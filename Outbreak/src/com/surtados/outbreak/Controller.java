package com.surtados.outbreak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    public void closeButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
