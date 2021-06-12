package com.surtados.outbreak.Screens.CharacterSelection;

import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.components.characterBox.CharacterBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

public class CharacterSelectionController {

    @FXML private Button btnAvancar;
    @FXML private GridPane gridPersonagens = new GridPane();

    @FXML private CharacterBox alice, fadinha, gosminha, troll, arqueiro, pyromancer, gengah, mrcanhao;
    ArrayList<Personagem> personagens = new ArrayList<>();

    @FXML private Guerreira guerreira;

    // Função para selecionar o personagem
    @FXML private void selectCharacter(MouseEvent event) {
        if (event.getSource() == alice) {
            alice.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == fadinha) {
            fadinha.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == gengah) {
            gengah.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == troll) {
            troll.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == mrcanhao) {
            mrcanhao.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == arqueiro) {
            arqueiro.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == pyromancer) {
            pyromancer.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }
        else if (event.getSource() == gosminha) {
            gosminha.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
        }

    }

    // Função para adicionar o personagem no time
    @FXML private void addCharacterTeam() {}

    // Função para remover o personagem do time
    @FXML private void removeCharacterTeam() {}

    // Função para confirmar o time e ir para a próxima página
    @FXML private void confirmTeamNextPage() {}

    @FXML private void botaoAvancarConfig() {
        btnAvancar.setDisable(true);
    }

    @FXML private void criaGridPane(ContextMenuEvent event) {
        gridPersonagens.getColumnConstraints().addAll(setCC(), setCC());
        gridPersonagens.getRowConstraints().addAll(setRC(), setRC(), setRC(), setRC());
    }

    private RowConstraints setRC() {
        RowConstraints rc = new RowConstraints();
        rc.setFillHeight(true);
        return rc;
    }
    private ColumnConstraints setCC() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setFillWidth(true);
        return cc;
    }
}
