package com.surtados.outbreak.Screens.GiveItemCharacter;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Personagem;
import com.surtados.outbreak.components.TeamBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GiveItemCharacterController implements Initializable {

    @FXML
    TeamBox actualBox;

    @FXML
    HBox teamList;

    @FXML
    Button btnAvancar;

    private void getTeamList() {
        ObservableList<Node> listaTime = teamList.getChildren();
        for (Personagem per : Sistema.players.get(Sistema.rodada).time) {
            actualBox = new TeamBox(per.sprite.getPath());
            actualBox.setOnMouseClicked(event -> {
                try {
                    selectCharacterToGive(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            listaTime.add(actualBox);
        }
    }

    @FXML private void selectCharacterToGive(MouseEvent event) throws IOException {
        TeamBox selecionado = (TeamBox) event.getSource();
        if (teamList.getChildren().contains(selecionado)) {
            for (Node no : teamList.getChildren()) {
                TeamBox temp = (TeamBox) no;
                if (temp.background.substring(90, (temp.background.length() - 4)).equals(selecionado.background.substring(90, (selecionado.background.length() - 4)))) {
                    System.out.println("entrou");
                temp.setStyle("-fx-min-width: 30px; -fx-min-height: 30px; -fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;" + "-fx-background-image: url('file:///" + temp.iconBackground + "');");
                btnAvancar.setDisable(false);
                return;
                }
            }
        }
    }

    @FXML private void avancarProximoPlayer(MouseEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;

        if (Sistema.rodada > 1) {
    // TODO SORTEAR PLAYERS
            Sistema.rodada = 0;
            String nextPageCSS = getClass().getResource("../Mapa/mapa.css").toExternalForm();

            if(event.getSource()==btnAvancar){
                stage = (Stage) btnAvancar.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../Mapa/mapa.fxml"));
            }
            Scene cena = new Scene(root);
            cena.getStylesheets().add(nextPageCSS);
            stage.setScene(cena);
            stage.show();
        } else {
            Sistema.rodada++;
            stage = null;
            root = null;
            String backGiveCSS = getClass().getResource("../ItemSelection/item.css").toExternalForm();

            if(event.getSource()==btnAvancar){
                stage = (Stage) btnAvancar.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../ItemSelection/item.fxml"));
            }
            Scene cena = new Scene(root);
            cena.getStylesheets().add(backGiveCSS);
            stage.setScene(cena);
            stage.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getTeamList();
    }
}
