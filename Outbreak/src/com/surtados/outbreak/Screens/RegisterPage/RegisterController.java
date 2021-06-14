package com.surtados.outbreak.Screens.RegisterPage;

import com.surtados.outbreak.Core.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    TextField nameField, emailField, passwordField;

    @FXML
    Button registerButton;

    boolean registrou;


    @FXML
    private void backLogin(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        registrou = Sistema.registrar(nameField.getText(), emailField.getText(), passwordField.getText());

        if (registrou) {
            String loginCSS = getClass().getResource("../LoginPage/login.css").toExternalForm();

            if(event.getSource()==registerButton){
                stage = (Stage) registerButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../LoginPage/login.fxml"));
            }
            Scene cena = new Scene(root);
            cena.getStylesheets().add(loginCSS);
            stage.setScene(cena);
            stage.show();
        }

    }
}
