package com.surtados.outbreak.Screens.Field;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.Utils.Dados;
import com.surtados.outbreak.components.ObstaculoBox;
import com.surtados.outbreak.components.TeamBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    @FXML
    public GridPane mapa, tabuleiro = new GridPane();

    Mapa mapaInterno = new Mapa(Mapa.linhas, Mapa.colunas);

    public ArrayList<Personagem> personagens = new ArrayList<>();
    public ArrayList<Obstaculo> obstaculos = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    ArrayList<Coordenada> alcancaveis = new ArrayList<>();
    @FXML private ObservableList<Node> personagensCampo = tabuleiro.getChildren();
    @FXML TeamBox temp;
    Personagem generico;

    @FXML Button botaoPassarTurno = new Button("Passar turno"), botaoMover = new Button("Mover");

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
        mapaInterno.personagens.add(p);
        tabuleiro.add(p.getTeamBox(), p.coord.getColuna(), p.coord.getLinha());
    }

    public void inserirObsetaculo(Obstaculo o) {
        obstaculos.add(o);
        mapaInterno.obstaculos.add(o);
        tabuleiro.add(o.getObstaculoBox(), o.coord.getColuna(), o.coord.getLinha());
    }

    public void removerPersonagem(Personagem p) {
        Item i;
        personagens.remove(p);
        tabuleiro.add(new Label(""), p.coord.getLinha(), p.coord.getColuna());
        if (Dados.random(100) >= 60) {
            int pocao = Dados.random(5);
            if (pocao == 1) {
                i = new Item("CURA");
            } else if (pocao == 2){
                i = new Item("MANA");
            }else if (pocao == 3){
                i = new Item("ATK");
            }else if (pocao == 4){
                i = new Item("DEF");
            }else {
                i = new Item("AGL");
            }
            i.coord.setPosicao(p.coord.getLinha(), p.coord.getColuna());
            items.add(i);
            tabuleiro.add(i.getItemBox(), i.coord.getLinha(), i.coord.getColuna());
        }
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
            p1.get(i).getTeamBox().setOnMouseClicked(event -> {
                selectCharacter(event);
            });
            inserirPersonagem(p1.get(i));
            p2.get(i).coord.setPosicao(cDir.get(i).getLinha(), cDir.get(i).getColuna());
            p2.get(i).setTeamBox(new TeamBox(p2.get(i).sprite.getPath()));
            p2.get(i).getTeamBox().setOnMouseClicked(event -> {
                selectCharacter(event);
            });
            inserirPersonagem(p2.get(i));
        }
    }

    public static Node removeNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {

        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if (node instanceof TeamBox && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                TeamBox imageView = new TeamBox("");
                System.out.println("Entrou no função maluca");
                gridPane.getChildren().remove(imageView);
                break;
            }
        }
        return (Node) childrens;
    }

    @FXML public void mostrarDialogin(MouseEvent event, Personagem p) {
        final Stage dialog = new Stage();
        dialog.setTitle(p.getNome() + " | Vida: " + p.getVida() + " | Mana: " + p.getMana());
        dialog.setResizable(false);
        dialog.setOnCloseRequest(evento -> {
            if (Sistema.rodada == 1) {
                Sistema.rodada = 0;
                return;
            }
            Sistema.rodada++;
        });
        dialog.initModality(Modality.WINDOW_MODAL);
//        dialog.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);
        ObservableList<Node> opcoes = dialogVbox.getChildren();
        opcoes.add(new Text("Menu de Opções"));
        opcoes.add(botaoMover);
        botaoMover.setOnMouseClicked(event1 -> {
            dialog.close();
            ArrayList<Coordenada> coordenadas;
            coordenadas = p.getAlcance(mapaInterno);
            alcancaveis = coordenadas;
            for (Coordenada c : coordenadas) {
                TeamBox tbGenerico = new TeamBox("");
                tbGenerico.coord.setPosicao(c.getLinha(), c.getColuna());
                tbGenerico.setOnMouseClicked(event2 -> {
                    if (event2.getSource() == tbGenerico) {
                        p.mover(tbGenerico.coord.getLinha(), tbGenerico.coord.getColuna(), mapaInterno, tabuleiro);
                        for (Coordenada coord : alcancaveis) {
                            if (coord != p.coord) {
                                removeNodeByRowColumnIndex(coord.getLinha(), coord.getColuna(), tabuleiro);
                                alcancaveis.remove(coord);
                            }
                        }
                        alcancaveis.clear();
                    }
                });
                tabuleiro.add(tbGenerico, c.getColuna(), c.getLinha());
                Obstaculo obsTemp = new Obstaculo("");
                obsTemp.coord.setPosicao(c.getLinha(),c.getColuna());
                mapaInterno.inserirObsetaculo(obsTemp);
            }
        });
        opcoes.add(new Button("Atacar"));
        opcoes.add(new Button("Usar item"));
        botaoPassarTurno.setOnMouseClicked(event1 -> {
            dialog.close();
            if (Sistema.rodada == 1) {
                Sistema.rodada = 0;
                return;
            }
            Sistema.rodada++;
        });
        opcoes.add(botaoPassarTurno);
        Scene dialogScene = new Scene(dialogVbox, 400, 200);

        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML private void selectCharacter(MouseEvent event) {
        TeamBox selecionado = (TeamBox) event.getSource();
        for (Personagem p : Sistema.players.get(Sistema.rodada).time) {
            if (p.getTeamBox() == selecionado) {
                mostrarDialogin(event, p);
                return;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Sistema.rodada = 0;
        Sistema.sortearPlayers(Sistema.players);
        criaGridPane();
        organizarPersonagens(Sistema.players.get(0).time, Sistema.players.get(1).time);
        System.out.println("RODADA: " + Sistema.rodada);
    }
}
