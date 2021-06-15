package com.surtados.outbreak.components;

import javafx.scene.layout.VBox;

public class ObstaculoBox extends VBox {
    public String background;
    public String iconBackground;

    public ObstaculoBox(String bg) {
        background = bg;
        String nomePersonagem = "";
        if (bg.length() >= 50) {
            nomePersonagem = bg.substring(90);
        }
        String novoCaminho = "".concat(nomePersonagem);
        novoCaminho = "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/" + novoCaminho;
        iconBackground = novoCaminho;
        setStyle("-fx-border-radius: 5px; -fx-min-width: 45px; -fx-min-height: 45px; -fx-max-width: 45px; -fx-max-height: 45px; -fx-background-image: url('file:///" + novoCaminho + "');");
    }
}
