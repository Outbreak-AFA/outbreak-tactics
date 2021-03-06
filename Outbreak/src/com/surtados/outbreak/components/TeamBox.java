package com.surtados.outbreak.components;

import com.surtados.outbreak.Models.Coordenada;
import javafx.scene.layout.VBox;

public class TeamBox extends VBox {

    public String background;
    public String iconBackground;
    public String nome;
    public Coordenada coord = new Coordenada();

    public TeamBox(String bg) {
        background = bg;
        String nomePersonagem = "";
        if (bg.length() >= 50) {
            nomePersonagem = bg.substring(90);
            nome = nomePersonagem;
        }
        String novoCaminho = "icon-".concat(nomePersonagem);
        novoCaminho = "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/" + novoCaminho;
        iconBackground = novoCaminho;
        if (!bg.isEmpty()) {
            setStyle("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-image: url('file:///" + novoCaminho + "');");
        } else {
            setStyle("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-color: rgb(28, 177, 20);");
        }
    }
}
