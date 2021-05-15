package com.surtados.outbreak.Models;

public class Obstaculo {
    public Coordenada coord = new Coordenada();
    public Sprite sprite = new Sprite();

    public Obstaculo(char simb) {
       sprite.setCharacter(simb);
    }

}
