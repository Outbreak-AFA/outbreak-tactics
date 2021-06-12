package com.surtados.outbreak.Screens.FirstPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    @FXML private javafx.scene.control.Button closeButton, startButton, creditsButton, rulesButton;

    @FXML
    public void closeButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void login(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        String loginPageCSS = getClass().getResource("../LoginPage/login.css").toExternalForm();

        if(event.getSource()==startButton){
            stage = (Stage) startButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../LoginPage/login.fxml"));
        }
        Scene cena = new Scene(root);
        cena.getStylesheets().add(loginPageCSS);
        stage.setScene(cena);
        stage.show();
    }

    @FXML
    private void credits(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        String creditsCSS = getClass().getResource("../Credits/credits.css").toExternalForm();

        if(event.getSource()==creditsButton){
            stage = (Stage) creditsButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../Credits/credits.fxml"));
        }
        Scene cena = new Scene(root);
        cena.getStylesheets().add(creditsCSS);
        stage.setScene(cena);
        stage.show();
    }

}
