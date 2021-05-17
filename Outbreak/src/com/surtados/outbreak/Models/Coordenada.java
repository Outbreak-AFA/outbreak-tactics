package com.surtados.outbreak.Models;

import java.util.ArrayList;

public class Coordenada {
    private int coluna, linha;

    public Coordenada clone() {
        Coordenada novaCoord = new Coordenada();
        novaCoord.setPosicao(getLinha(), getColuna());
        return novaCoord;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setPosicao(int linha, int coluna) {
        setColuna(coluna); setLinha(linha);
    }

    public boolean equals(Coordenada coord) {
        if (getColuna() == coord.getColuna() && (getLinha() == coord.getLinha())) return true;
        return false;
    }
    public boolean equals(int lin, int col) {
        if (getColuna() == col && (getLinha() == lin)) return true;
        return false;
    }

    public boolean equals(ArrayList<Coordenada> proibidos) {
        for (Coordenada c : proibidos) {
            if (equals(c)) return false;
        }
        return true;
    }
}
