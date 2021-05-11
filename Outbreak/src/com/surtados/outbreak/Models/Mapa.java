package com.surtados.outbreak.Models;

import java.util.ArrayList;

/*
* TODO
*
* */

public class Mapa {
    private char[][] matriz;
    public ArrayList<Personagem> personagens = new ArrayList<>();
    public ArrayList<Obstaculo> obstaculos = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    private int linhaMax, colunaMax;

   public Mapa(int linha, int coluna) {
       setColunaMax(coluna);
       setLinhaMax(linha);
       matriz = preencherMapa(linha, coluna);
   }

    public int getLinhaMax() {
        return linhaMax;
    }

    public void setLinhaMax(int linhaMax) {
        this.linhaMax = linhaMax;
    }

    public int getColunaMax() {
        return colunaMax;
    }

    public void setColunaMax(int colunaMax) {
        this.colunaMax = colunaMax;
    }

    public char[][] preencherMapa(int linha, int coluna) {
       char[][] matrizTemp = new char[linha][coluna];
       Obstaculo muro = new Obstaculo('=');
        for (int i=0; i<linha; i++) {
            for (int j=0; j<coluna; j++) {
               if (j == 0 || j == coluna-1) {
                   muro.coord.setPosicao(i, j, this);
                   obstaculos.add(muro);
                   matrizTemp[i][j] = muro.getSimbolo();
               } else if (i == 0 || i == linha-1) {
                   muro.coord.setPosicao(i, j, this);
                   obstaculos.add(muro);
                   matrizTemp[i][j] = muro.getSimbolo();
               } else matrizTemp[i][j] = '*';
            }
        }
        return matrizTemp;
    }

    public void setMatriz(char c, int linha, int coluna, int linhaAnt, int colunaAnt) {
       matriz[linhaAnt][colunaAnt] = '*';
       matriz[linha][coluna] = c;
    }

    public void plotarMatriz() {
        for (int i=0; i<getLinhaMax(); i++) {
            for (int j = 0; j < getColunaMax(); j++) {
                System.out.print(matriz[i][j]);
            }
                System.out.println();
        }
    }

}
