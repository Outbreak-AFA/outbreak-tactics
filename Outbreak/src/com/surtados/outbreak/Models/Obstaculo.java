package com.surtados.outbreak.Models;

import com.surtados.outbreak.components.ObstaculoBox;

public class Obstaculo {
    public Coordenada coord = new Coordenada();
    public Sprite sprite = new Sprite();
    public ObstaculoBox obstaculoBox;

    public Obstaculo clone() {
        Obstaculo novoObs = new Obstaculo(sprite.getPath());
        novoObs.coord.setPosicao(coord.getLinha(), coord.getColuna());
        return novoObs;
    }

    public Obstaculo(String path) {
        sprite.setPath(path);
    }


    public ObstaculoBox getObstaculoBox() {
        return obstaculoBox;
    }

    public void setObstaculoBox(ObstaculoBox obstaculoBox) {
        this.obstaculoBox = obstaculoBox;
    }
}
