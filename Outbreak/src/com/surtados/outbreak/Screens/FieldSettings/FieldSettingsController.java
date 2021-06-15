package com.surtados.outbreak.Screens.FieldSettings;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Mapa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FieldSettingsController {
    @FXML private javafx.scene.control.Button botaoStart;

    @FXML
    TextField teamLimit, fieldRow, fieldColumn;

    @FXML
    private void characterSelection(ActionEvent event) throws Exception {
        setTeamLimit();
        setMapaSize();
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

    @FXML private void setTeamLimit() {
        if (teamLimit.getText() == null || teamLimit.getText().isEmpty() || teamLimit.getText().isBlank()) {
            return;
        }
        Sistema.limitePersonagens = Integer.parseInt(teamLimit.getText());
    }

    @FXML private void setMapaSize() {
        Mapa.colunas = Integer.parseInt(fieldColumn.getText());
        Mapa.linhas = Integer.parseInt(fieldRow.getText());
    }
}
