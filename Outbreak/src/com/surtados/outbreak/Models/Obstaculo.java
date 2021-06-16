package com.surtados.outbreak.Models;

import com.surtados.outbreak.components.ObstaculoBox;

public class Obstaculo {
    public Coordenada coord = new Coordenada();
    public Sprite sprite = new Sprite();
    public ObstaculoBox obstaculoBox;

    public Obstaculo clone() {
        Obstaculo novoObs = new Obstaculo();
        novoObs.coord.setPosicao(coord.getLinha(), coord.getColuna());
        return novoObs;
    }

    public Obstaculo() {
        sprite.setPath("E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/obstaculo.png");
    }


    public ObstaculoBox getObstaculoBox() {
        return obstaculoBox;
    }

    public void setObstaculoBox(ObstaculoBox obstaculoBox) {
        this.obstaculoBox = obstaculoBox;
    }
}
