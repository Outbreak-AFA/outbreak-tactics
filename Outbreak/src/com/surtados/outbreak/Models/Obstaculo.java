package com.surtados.outbreak.Models;

public class Obstaculo {
    public Coordenada coord = new Coordenada();
    private char simbolo;

    public Obstaculo(char simb) {
        setSimbolo(simb);
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
