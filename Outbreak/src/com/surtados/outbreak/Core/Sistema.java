package com.surtados.outbreak.Core;

import com.surtados.outbreak.Models.Coordenada;
import com.surtados.outbreak.Models.Mapa;
import com.surtados.outbreak.Models.Obstaculo;
import com.surtados.outbreak.Models.Personagem;
import com.surtados.outbreak.Utils.Dados;

import java.util.ArrayList;

public class Sistema {
    public static boolean acertou(Personagem p) {
        int valor = Dados.random(20, p.getAgl() * (-1));
        if (valor >= 5) return  true;
        return false;
    }

    public static ArrayList<Coordenada> getAlcance(Personagem personagem, Mapa mapa) {
        boolean possivel;
        int agl = personagem.getAgl();
        ArrayList<Coordenada> coordPadrao = new ArrayList<>();
        Coordenada personagemCoord = personagem.coord;
        Coordenada tempCoord = new Coordenada();
        ArrayList<Coordenada> possiveisCoordenadas = new ArrayList<>();

        // criando alcance padrão 3x3
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (i != 0 && j != 0) {
                    tempCoord.setPosicao(personagemCoord.getLinha() + i,
                            personagemCoord.getColuna() + j);
                    coordPadrao.add(tempCoord.clone());
                }
            }
        }

        if (agl >= 4) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() , personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha(), personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());
        }
        if (agl >= 6) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 3, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() , personagemCoord.getColuna() - 3);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha(), personagemCoord.getColuna() + 3);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 3, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());
        }
        if (agl >= 8) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2 , personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());
        }
        if (agl >= 10) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() - 1);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() + 1);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 1, personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 1, personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 1, personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 1 , personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna() - 1);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna() + 1);
            coordPadrao.add(tempCoord.clone());
        }
        // verificando obstáculos
        for (Coordenada cp : coordPadrao) {
            possivel = true;
            for (Obstaculo ob : mapa.obstaculos) {
                if (cp.getLinha() == ob.coord.getLinha() && (cp.getColuna() == ob.coord.getColuna())) {
                    possivel = false;
                }
            }
            if (possivel) possiveisCoordenadas.add(cp);
        }
        return possiveisCoordenadas;
    }
}
