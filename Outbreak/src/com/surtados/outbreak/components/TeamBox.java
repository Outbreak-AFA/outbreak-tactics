package com.surtados.outbreak.components;

import javafx.scene.layout.VBox;

public class TeamBox extends VBox {

    public TeamBox(String bg) {
        String nomePersonagem = bg.substring(90);
        String novoCaminho = "icon-".concat(nomePersonagem);
        novoCaminho = "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/" + novoCaminho;
        setStyle("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-image: url('file:///" + novoCaminho + "');");
        System.out.println("Foi criado\n" + novoCaminho);
    }
}
