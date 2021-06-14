package com.surtados.outbreak.Screens.LoginPage;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {

    @FXML private javafx.scene.control.Button registerButton, enterButton;
    @FXML private TextField loginField, passwordField;
    ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

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
        validateLogin();
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

    @FXML private void validateLogin() {
        Player teste = Sistema.login(loginField.getText(), passwordField.getText());
        players.add(teste);
    }

}
