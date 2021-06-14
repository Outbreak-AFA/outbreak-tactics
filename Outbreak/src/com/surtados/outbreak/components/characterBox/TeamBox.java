package com.surtados.outbreak.components.characterBox;

import javafx.scene.layout.VBox;

public class TeamBox extends VBox {

    public TeamBox(String bg) {
        setStyle("-fx-min-width: 30; -fx-min-height: 30; -fx-backgorund-image: url('" + bg + "');");
    }
}
