package com.surtados.outbreak.Screens.ItemSelection;

import com.surtados.outbreak.Core.Sistema;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemSelectionController implements Initializable {
    @FXML
    Label mensagemItem = new Label("Opa, Fulano! Pelo visto você\npossui itens especiais.\nDeseja adicionar algum deles\nao seu time?");

    @FXML Button aceitarBtn, recusarBtn;
    int cont = 0;

    @FXML private void aceitar(MouseEvent event) {
        if (event.getSource() == aceitarBtn) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Sistema.players.get(Sistema.rodada).conquistas.size() > 0) {
            mensagemItem.setText("Opa, " + Sistema.players.get(Sistema.rodada).getNome() + "! Pelo visto você\npossui itens especiais.\nDeseja adicionar algum deles\nao seu time?");
        }
    }
}
