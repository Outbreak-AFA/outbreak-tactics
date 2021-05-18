package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Utils.Dados;

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

    public void inserirPersonagem(Personagem p) {
       personagens.add(p);
       matriz[p.coord.getLinha()][p.coord.getColuna()] = p.sprite.getCharacter();
    }

    public void inserirObsetaculo(Obstaculo o) {
        obstaculos.add(o);
        matriz[o.coord.getLinha()][o.coord.getColuna()] = o.sprite.getCharacter();
    }

    public char[][] preencherMapa(int linha, int coluna) {
       char[][] matrizTemp = new char[linha][coluna];
       Obstaculo muro = new Obstaculo('=');
        for (int i=0; i<linha; i++) {
            for (int j=0; j<coluna; j++) {
               if (j == 0 || j == coluna-1) {
                   muro.coord.setPosicao(i, j);
                   obstaculos.add(muro);
                   matrizTemp[i][j] = muro.sprite.getCharacter();
               } else if (i == 0 || i == linha-1) {
                   muro.coord.setPosicao(i, j);
                   obstaculos.add(muro);
                   matrizTemp[i][j] = muro.sprite.getCharacter();
               } else matrizTemp[i][j] = ' ';
            }
        }
        return matrizTemp;
    }

    public void setMatriz(char c, int linha, int coluna, int linhaAnt, int colunaAnt) {
       matriz[linhaAnt][colunaAnt] = ' ';
       matriz[linha][coluna] = c;
    }

    public void plotarMatriz() {
        System.out.println("------".repeat(getColunaMax()));
        for (int i=0; i<getLinhaMax(); i++) {
            for (int j = 0; j < getColunaMax(); j++) {
                System.out.print("  " + matriz[i][j] + "  |");
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
    public Object getPosicao(int lin, int col, ArrayList<Coordenada> proibidas) {
       for (Obstaculo o : obstaculos) {
           if (o.coord.equals(lin, col)) {
               return o;
           }
       }
       for (Personagem p : personagens) {
           if (p.coord.equals(lin, col)) {
               return p;
           }
       }
       for (Coordenada c : proibidas) {
           if (c.equals(lin, col)) {
               return c;
           }
       }
       return null;
    }

    public boolean posicaoVazia(int lin, int col, ArrayList<Coordenada> proibidas) {
       Object ob = getPosicao(lin, col, proibidas);
       if (ob == null) {
           return true;
       }
       return false;
    }

    public void organizarPersonagens(ArrayList<Personagem> p1, ArrayList<Personagem> p2) {
        gerarObstaculosAleatorios();
        ArrayList<Coordenada> cEsq = new ArrayList<>();
        ArrayList<Coordenada> cDir = new ArrayList<>();
        for (Coordenada c : gerarMeio()) {
            if (c.getColuna() == 1) {
                cEsq.add(c);
            } else cDir.add(c);
        }
        for (int i=0; i<Sistema.limitePersonagens; i++) {
            p1.get(i).coord.setPosicao(cEsq.get(i).getLinha(), cEsq.get(i).getColuna());
            inserirPersonagem(p1.get(i));
            p2.get(i).coord.setPosicao(cDir.get(i).getLinha(), cDir.get(i).getColuna());
            inserirPersonagem(p2.get(i));
        }
    }

    private ArrayList<Coordenada> gerarMeio() {
       int meio = getLinhaMax() / 2;
       int limite = Sistema.limitePersonagens;
       ArrayList<Coordenada> proibidas = new ArrayList<>();
       for (int i=0; i<limite; i++) {
           if (i==0) {
               Coordenada posEsq = new Coordenada();
               Coordenada posDir = new Coordenada();
               posEsq.setPosicao(meio, 1);
               posDir.setPosicao(meio, getColunaMax() - 2);
               proibidas.add(posEsq);
               proibidas.add(posDir);
           } else if (i%2 != 0) {
               meio += i;
               Coordenada posEsq = new Coordenada();
               Coordenada posDir = new Coordenada();
               posEsq.setPosicao(meio, 1);
               posDir.setPosicao(meio, getColunaMax() - 2);
               proibidas.add(posEsq);
               proibidas.add(posDir);
           } else {
               meio -= i;
               Coordenada posEsq = new Coordenada();
               Coordenada posDir = new Coordenada();
               posEsq.setPosicao(meio, 1);
               posDir.setPosicao(meio, getColunaMax() - 2);
               proibidas.add(posEsq);
               proibidas.add(posDir);
           }
       }
    return proibidas;
    }

    private void gerarObstaculosAleatorios() {
       int posLin = 0, posCol = 0;
       ArrayList<Coordenada> proibidas = gerarMeio();
       int k = 0;
       for (int i=0; i<getColunaMax() * 2; i++) {
           while (k == 0) {
               posLin = Dados.random(getLinhaMax() - 2);
               posCol = Dados.random(getColunaMax() - 2);
               for (Coordenada c : proibidas) {
                   if (c.equals(posLin, posCol)) k = 0;
                   k = 1;
               }
           }
           k = 0;
           Obstaculo obs = new Obstaculo('■');
           obs.coord.setPosicao(posLin, posCol);
           inserirObsetaculo(obs);
       }
    }
}
