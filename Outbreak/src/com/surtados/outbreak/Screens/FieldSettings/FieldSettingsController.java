package com.surtados.outbreak.Screens.FieldSettings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FieldSettingsController {
    @FXML private javafx.scene.control.Button botaoStart;

    @FXML
    private void characterSelection(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        String characterSelectionCSS = getClass().getResource("../CharacterSelection/characterSelecion.css").toExternalForm();

        if(event.getSource()==botaoStart){
            stage = (Stage) botaoStart.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../CharacterSelection/characterSelection.fxml"));
        }
        Scene cena = new Scene(root);
        cena.getStylesheets().add(characterSelectionCSS);
        stage.setScene(cena);
        stage.show();
    }

}
