package com.surtados.outbreak.Screens.LoginPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class LoginController {

    @FXML private javafx.scene.control.Button registerButton, enterButton;

    @FXML
    private void registerPage(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        String registerPageCSS = getClass().getResource("../RegisterPage/register.css").toExternalForm();

        if(event.getSource()==registerButton){
            stage = (Stage) registerButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../RegisterPage/register.fxml"));
        }
        Scene cena = new Scene(root);
        cena.getStylesheets().add(registerPageCSS);
        stage.setScene(cena);
        stage.show();
    }

    @FXML
    private void fieldSettings(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        String registerPageCSS = getClass().getResource("../FieldSettings/fieldSettings.css").toExternalForm();

        if(event.getSource()==enterButton){
            stage = (Stage) enterButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../FieldSettings/fieldSettings.fxml"));
        }
        Scene cena = new Scene(root);
        cena.getStylesheets().add(registerPageCSS);
        stage.setScene(cena);
        stage.show();
    }


}
