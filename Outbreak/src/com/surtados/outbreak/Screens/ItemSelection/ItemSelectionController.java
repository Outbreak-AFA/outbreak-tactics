package com.surtados.outbreak.Screens.ItemSelection;

import com.surtados.outbreak.Core.Sistema;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemSelectionController implements Initializable {
    @FXML
    Label mensagemItem = new Label("Opa, Fulano! Pelo visto você\npossui itens especiais.\nDeseja adicionar algum deles\nao seu time?");

    @FXML Button aceitarBtn, recusarBtn;
    @FXML
    GridPane grid;

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

    @FXML private void recusar(MouseEvent event) throws IOException {

        if (Sistema.rodada >= 1) {
            Stage stage = null;
            Parent root = null;
            String mapaCSS = getClass().getResource("../Field/field.css").toExternalForm();

            if (event.getSource() == recusarBtn) {
                stage = (Stage) recusarBtn.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../Field/field.fxml"));

                Scene cena = new Scene(root);
                cena.getStylesheets().add(mapaCSS);
                stage.setScene(cena);

                stage.show();
            }
        } else {
            System.out.println("Entrou no ELSE");
            Sistema.rodada++;
            reload();
        }

    }

    public void reload() {
        initialize(null, null);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> grid.requestLayout());// Update on JavaFX Application Thread
            }
        }).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Rodada: " + Sistema.rodada);
        if (Sistema.players.get(Sistema.rodada).conquistas.size() > 0) {
            mensagemItem.setText("Opa, " + Sistema.players.get(Sistema.rodada).getNome() + "! Pelo visto você\npossui itens especiais.\nDeseja adicionar algum deles\nao seu time?");
        } else {
         if (Sistema.rodada > 1) {
             Sistema.rodada = 0;
             Stage stage = null;
             Parent root = null;
             String giveItemsCSS = getClass().getResource("../Field/field.css").toExternalForm();

             stage = (Stage) grid.getScene().getWindow();
             try {
                 root = FXMLLoader.load(getClass().getResource("../Field/field.fxml"));
             } catch (IOException e) {
                 e.printStackTrace();
             }
             Scene cena = new Scene(root);
             cena.getStylesheets().add(giveItemsCSS);
             stage.setScene(cena);

             stage.show();
         } else {
             Sistema.rodada++;

             reload();
            }
        }
    }
}
