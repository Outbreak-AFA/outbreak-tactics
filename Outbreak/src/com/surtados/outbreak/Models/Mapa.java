package com.surtados.outbreak.Models;

import com.surtados.outbreak.Utils.Dados;

import java.util.ArrayList;

/*
 * TODO
 *
 * */

public class Mapa {
    public ArrayList<Personagem> personagens = new ArrayList<>();
    public ArrayList<Obstaculo> obstaculos = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    private int linhaMax, colunaMax;

    public static int colunas, linhas;

    public Mapa(int linha, int coluna) {
        setColunaMax(coluna);
        setLinhaMax(linha);
//        matriz = preencherMapa(linha, coluna);
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

    public void inserirObsetaculo(Obstaculo o) {
        obstaculos.add(o);
    }

    public void inserirItem(Item i) {
        items.add(i);
//        matriz[i.coord.getLinha()][i.coord.getColuna()] = i.sprite.getCharacter();
    }

    public void removerObstaculo(Obstaculo o) {
        obstaculos.remove(o);
//        matriz[o.coord.getLinha()][o.coord.getColuna()] = ' ';
    }
    public void removerItem(Item i) {
        items.remove(i);
//        matriz[i.coord.getLinha()][i.coord.getColuna()] = ' ';
    }

    public void removerPersonagem(Personagem p) {
        Item i;
        personagens.remove(p);
//        matriz[p.coord.getLinha()][p.coord.getColuna()] = ' ';
        if (Dados.random(100) >= 60) {
            int pocao = Dados.random(5);
            if (pocao == 1) {
                i = new Item("CURA");
            } else if (pocao == 2){
                i = new Item("MANA");
            }else if (pocao == 3){
                i = new Item("ATK");
            }else if (pocao == 4){
                i = new Item("DEF");
            }else {
                i = new Item("AGL");
            }
            i.coord.setPosicao(p.coord.getLinha(), p.coord.getColuna());
            items.add(i);
//            matriz[p.coord.getLinha()][p.coord.getColuna()] = i.sprite.getCharacter();
        }
    }

//    public char[][] preencherMapa(int linha, int coluna) {
//        char[][] matrizTemp = new char[linha][coluna];
////        Obstaculo muro = new Obstaculo('=');
//        for (int i=0; i<linha; i++) {
//            for (int j=0; j<coluna; j++) {
//                if (j == 0 || j == coluna-1) {
//                    muro.coord.setPosicao(i, j);
//                    obstaculos.add(muro);
//                    matrizTemp[i][j] = muro.sprite.getCharacter();
//                } else if (i == 0 || i == linha-1) {
//                    muro.coord.setPosicao(i, j);
//                    obstaculos.add(muro);
//                    matrizTemp[i][j] = muro.sprite.getCharacter();
//                } else matrizTemp[i][j] = ' ';
//            }
//        }
//        return matrizTemp;
//    }

    public void setMatriz(char c, int linha, int coluna, int linhaAnt, int colunaAnt) {
//        matriz[linhaAnt][colunaAnt] = ' ';
//        matriz[linha][coluna] = c;
    }

    public void plotarMatriz() {
        System.out.println("------".repeat(getColunaMax()));
        for (int i=0; i<getLinhaMax(); i++) {
            for (int j = 0; j < getColunaMax(); j++) {
//                if (matriz[i][j] == '#') {
//                    System.out.print(Cores.ANSI_GREEN + "  " + matriz[i][j] + Cores.ANSI_RESET + "  |");
//                } else
//                    System.out.print("  " + matriz[i][j] + "  |");
            }
            System.out.println();
        }
        System.out.println("------".repeat(getColunaMax()));
    }

    public Object getPosicao(int lin, int col) {
        for (Obstaculo o : obstaculos) {
            if (o.coord.equals(lin, col)) return o;
        }
        for (Personagem p : personagens) {
            if (p.coord.equals(lin, col)) return p;
        }
        return null;
    }

    public Personagem getPosicaoPersonagem(int lin, int col) {
        for (Personagem p : personagens) {
            if (p.coord.equals(lin, col)) return p;
        }
        return null;
    }
    public Object getPosicao(int lin, int col, ArrayList<Coordenada> proibidas, boolean identificarPersonagem) {
        for (Obstaculo o : obstaculos) {
            if (o.coord.equals(lin, col)) {
                return o;
            }
        }
        if (identificarPersonagem) {
            for (Personagem p : personagens) {
                if (p.coord.equals(lin, col)) {
                    return p;
                }
            }
        }
        for (Coordenada c : proibidas) {
            if (c.equals(lin, col)) {
                return c;
            }
        }
        return null;
    }

    public boolean posicaoVazia(int lin, int col, ArrayList<Coordenada> proibidas, boolean identificarPersonagem) {
        Object ob = getPosicao(lin, col, proibidas, identificarPersonagem);
        if (ob == null) {
            return true;
        }
        return false;
    }
}
