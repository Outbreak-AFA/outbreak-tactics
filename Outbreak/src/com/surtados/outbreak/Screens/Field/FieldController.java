package com.surtados.outbreak.Screens.Field;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Mapa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    @FXML
    GridPane mapa;
    public Mapa field = Sistema.configMapa(Mapa.linhas, Mapa.colunas);

    @FXML
    private void criaGridPane() {
        ArrayList<RowConstraints> rcs = new ArrayList<>();
        ArrayList<ColumnConstraints> ccs = new ArrayList<>();

        for (int i=0; i<field.getLinhaMax(); i++) {
            for (int k=0; i<field.getColunaMax(); k++) {
                ccs.add(setCC());
            }
            rcs.add(setRC());
        }
        mapa.getColumnConstraints().addAll(ccs);
        mapa.getRowConstraints().addAll(rcs);
        mapa.setGridLinesVisible(true);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criaGridPane();
    }
}
