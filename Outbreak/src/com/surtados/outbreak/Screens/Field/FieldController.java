package com.surtados.outbreak.Screens.Field;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Coordenada;
import com.surtados.outbreak.Models.Mapa;
import com.surtados.outbreak.Models.Obstaculo;
import com.surtados.outbreak.Models.Personagem;
import com.surtados.outbreak.Utils.Dados;
import com.surtados.outbreak.components.ObstaculoBox;
import com.surtados.outbreak.components.TeamBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    @FXML
    public GridPane mapa, tabuleiro = new GridPane();
    public ArrayList<Personagem> personagens = new ArrayList<>();
    public ArrayList<Obstaculo> obstaculos = new ArrayList<>();
    @FXML private ObservableList<Node> personagensCampo = tabuleiro.getChildren();

    @FXML
    private void criaGridPane() {
        tabuleiro.setGridLinesVisible(true);
        for (int i=0; i<Mapa.linhas-3; i++) {
            tabuleiro.getRowConstraints().add(setRC());
        }
        for (int i=0; i<Mapa.colunas-2; i++) {
            tabuleiro.getColumnConstraints().add(setCC());
        }
    }

    public void inserirPersonagem(Personagem p) {
        personagens.add(p);
        tabuleiro.add(p.getTeamBox(), p.coord.getColuna(), p.coord.getLinha());
    }

    public void inserirObsetaculo(Obstaculo o) {
        obstaculos.add(o);
        tabuleiro.add(o.getObstaculoBox(), o.coord.getColuna(), o.coord.getLinha());
    }

    private RowConstraints setRC() {
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        rc.setValignment(VPos.CENTER);
        rc.setFillHeight(true);
        return rc;
    }
    private ColumnConstraints setCC() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        cc.setHalignment(HPos.CENTER);
        cc.setFillWidth(true);
        return cc;
    }

    private ArrayList<Coordenada> gerarMeio() {
        int meio = Mapa.linhas / 2;
        int limite = Sistema.limitePersonagens;
        ArrayList<Coordenada> proibidas = new ArrayList<>();
        for (int i=0; i<limite; i++) {
            if (i==0) {
                Coordenada posEsq = new Coordenada();
                Coordenada posDir = new Coordenada();
                posEsq.setPosicao(meio, 1);
                posDir.setPosicao(meio, Mapa.colunas - 2);
                proibidas.add(posEsq);
                proibidas.add(posDir);
            } else if (i%2 != 0) {
                meio += i;
                Coordenada posEsq = new Coordenada();
                Coordenada posDir = new Coordenada();
                posEsq.setPosicao(meio, 1);
                posDir.setPosicao(meio, Mapa.colunas - 2);
                proibidas.add(posEsq);
                proibidas.add(posDir);
            } else {
                meio -= i;
                Coordenada posEsq = new Coordenada();
                Coordenada posDir = new Coordenada();
                posEsq.setPosicao(meio, 1);
                posDir.setPosicao(meio, Mapa.colunas - 2);
                proibidas.add(posEsq);
                proibidas.add(posDir);
            }
        }
        return proibidas;
    }
//
    private void gerarObstaculosAleatorios() {
        int posLin = 0, posCol = 0;
        ArrayList<Coordenada> proibidas = gerarMeio();
        int k = 0;
        for (int i=0; i<(tabuleiro.getColumnCount() / 2 + (tabuleiro.getRowCount() / 4)); i++) {
            while (k == 0) {
                posLin = Dados.random(tabuleiro.getRowCount() - 2);
                posCol = Dados.random(tabuleiro.getColumnCount() - 2);
                for (Coordenada c : proibidas) {
                    if (c.equals(posLin, posCol)) k = 0;
                    k = 1;
                }
            }
            k = 0;
            if (posCol == 1) {
                posCol++;
            } else if (posCol == tabuleiro.getColumnCount() - 2) {
                posCol--;
            }
            Obstaculo obs = new Obstaculo("E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/obstaculo.png");
            obs.setObstaculoBox(new ObstaculoBox(obs.sprite.getPath()));
            obs.coord.setPosicao(posLin, posCol);
            inserirObsetaculo(obs);
        }
    }

    public void organizarPersonagens(ArrayList<Personagem> p1, ArrayList<Personagem> p2) {
        gerarObstaculosAleatorios();
        ArrayList<Coordenada> cEsq = new ArrayList<>();
        ArrayList<Coordenada> cDir = new ArrayList<>();
        for (Coordenada c : gerarMeio()) {
            if (c.getColuna() == 1) {
                cEsq.add(c);
            } else cDir.add(c);
        }
        for (int i=0; i<Sistema.limitePersonagens; i++) {
            p1.get(i).coord.setPosicao(cEsq.get(i).getLinha(), cEsq.get(i).getColuna());
            p1.get(i).setTeamBox(new TeamBox(p1.get(i).sprite.getPath()));
            inserirPersonagem(p1.get(i));
            p2.get(i).coord.setPosicao(cDir.get(i).getLinha(), cDir.get(i).getColuna());
            p2.get(i).setTeamBox(new TeamBox(p2.get(i).sprite.getPath()));
            inserirPersonagem(p2.get(i));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criaGridPane();
        organizarPersonagens(Sistema.players.get(0).time, Sistema.players.get(1).time);
    }
}
