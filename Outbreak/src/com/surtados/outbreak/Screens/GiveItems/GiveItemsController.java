package com.surtados.outbreak.Screens.GiveItems;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class GiveItemsController implements Initializable {

    @FXML
    Label giveMessage = new Label("Escolha um item mágico para\nconcedê-lo a um personagem de seu\ntime!"), itemDescription;

    @FXML
    HBox itemList;

    @FXML
    VBox itemAtk, itemDef, itemAgl;

    @FXML
    Button btnAvancar;

    private void temItem() {
        for (Item item : Sistema.players.get(Sistema.rodada).conquistas) {
            if (item.getTipoDeItem().equals("ATK")) itemAtk.setDisable(false);
            else if (item.getTipoDeItem().equals("DEF")) itemDef.setDisable(false);
            else if (item.getTipoDeItem().equals("AGL")) itemAgl.setDisable(false);
        }
    }

    @FXML private void selecionarItem(MouseEvent event) {
        resetBorder();
        if (event.getSource() == itemAtk) {
            itemAtk.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/atk.png');");
            Sistema.conquistaEspecialEscolhida = "ATK";
            btnAvancar.setDisable(false);
        }
        else if (event.getSource() == itemAgl) {
            itemAgl.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/agl.png');");
            Sistema.conquistaEspecialEscolhida = "AGL";
            btnAvancar.setDisable(false);
        }
        else if (event.getSource() == itemDef) {
            itemDef.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/def.png');");
            Sistema.conquistaEspecialEscolhida = "DEF";
            btnAvancar.setDisable(false);
        }
        itemDescription.setText(new Item(Sistema.conquistaEspecialEscolhida).descricao());
    }

    @FXML private void resetBorder() {
        itemAtk.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/atk.png');");
        itemAgl.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/agl.png');");
        itemDef.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/def.png');");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        giveMessage.setText("Escolha um item mágico para\nconcedê-lo a um personagem de seu\ntime!");
        itemAgl.setStyle("-fx-border-radius: 10px; -fx-border-width: 3px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/agl.png')");
        itemAtk.setStyle("-fx-border-radius: 10px; -fx-border-width: 3px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/atk.png')");
        itemDef.setStyle("-fx-border-radius: 10px; -fx-border-width: 3px; -fx-background-image: url('file:///E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/def.png')");
        temItem();
    }
}
