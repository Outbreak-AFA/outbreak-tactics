package com.surtados.outbreak.components;

import javafx.scene.layout.VBox;

public class ItemBox extends VBox {

    public String background;

    public ItemBox(String tipoItem) {
        String novoCaminho = tipoItem;
        novoCaminho = "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/" + novoCaminho.toLowerCase() + ".png";
        setStyle("-fx-border-radius: 15px; -fx-min-width: 80px; -fx-min-height: 80px; -fx-max-width: 80px; -fx-max-height: 80px; -fx-background-image: url('file:///" + novoCaminho + "');");
    }

    public String getBackgroundd() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
