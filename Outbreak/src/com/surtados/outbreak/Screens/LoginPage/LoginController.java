package com.surtados.outbreak.Screens.LoginPage;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private javafx.scene.control.Button registerButton, enterButton;
    @FXML private TextField loginField, passwordField;

    @FXML
    Label loginText;

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
        Player pValidate = validateLogin();
        Stage stage = null;
        Parent root = null;

        if (pValidate != null) {
            loginText.setText("Faça o login do 2º jogador!");
            Sistema.players.add(pValidate);
            Sistema.rodada ++;
            loginField.clear();
            passwordField.clear();
            if (Sistema.rodada > 1) {
                String registerPageCSS = getClass().getResource("../FieldSettings/fieldSettings.css").toExternalForm();

                if(event.getSource()==enterButton){
                    stage = (Stage) enterButton.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("../FieldSettings/fieldSettings.fxml"));
                }
                Scene cena = new Scene(root);
                Sistema.rodada = 0;
                cena.getStylesheets().add(registerPageCSS);
                stage.setScene(cena);
                stage.show();
            }
        }
        return;
    }

    @FXML private Player validateLogin() {
        while (Sistema.rodada <= 1) {
            Player player = Sistema.login(loginField.getText(), passwordField.getText());
            return player;
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginText.setText("Faça o login do " + (Sistema.rodada+1) + "º jogador!");
    }
}
