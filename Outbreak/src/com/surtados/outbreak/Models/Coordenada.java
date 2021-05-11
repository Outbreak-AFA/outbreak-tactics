package com.surtados.outbreak.Models;

public class Coordenada {
    private int coluna, linha;

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

    public void setPosicao(int linha, int coluna, Mapa mapa) {
        setColuna(coluna); setLinha(linha);
    }
}
