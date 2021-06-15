package com.surtados.outbreak.Screens.ItemSelection;

import com.surtados.outbreak.Core.Sistema;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemSelectionController implements Initializable {
    @FXML
    Label mensagemItem = new Label("Opa, Fulano! Pelo visto você\npossui itens especiais.\nDeseja adicionar algum deles\nao seu time?");

    @FXML Button aceitarBtn, recusarBtn;
    int cont = 0;

    @FXML private void aceitar(MouseEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        String giveItemsCSS = getClass().getResource("../GiveItems/give.css").toExternalForm();

        if (event.getSource() == aceitarBtn) {
            stage = (Stage) aceitarBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../GiveItems/give.fxml"));

            Scene cena = new Scene(root);
            cena.getStylesheets().add(giveItemsCSS);
            stage.setScene(cena);

            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Sistema.players.get(Sistema.rodada).conquistas.size() > 0) {
            mensagemItem.setText("Opa, " + Sistema.players.get(Sistema.rodada).getNome() + "! Pelo visto você\npossui itens especiais.\nDeseja adicionar algum deles\nao seu time?");
        }
    }
}
