package com.surtados.outbreak.Models;

public class Obstaculo {
    public Coordenada coord = new Coordenada();
    public Sprite sprite = new Sprite();

    public Obstaculo clone() {
        Obstaculo novoObs = new Obstaculo(sprite.getCharacter());
        novoObs.coord.setPosicao(coord.getLinha(), coord.getColuna());
        return novoObs;
    }

    public Obstaculo(char simb) {
        sprite.setCharacter(simb);
    }

}
