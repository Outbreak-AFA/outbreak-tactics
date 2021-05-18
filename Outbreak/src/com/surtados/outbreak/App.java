package com.surtados.outbreak;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.*;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
//        ArrayList<Player> players = new ArrayList<>();
//
//        boolean menu = Sistema.menuJogo();
//        if (!menu) {
//            System.out.println("Saindo do jogo!");
//            return;
//        }
//
//        System.out.println("Iniciando jogo!\n");
//        while (true) {
//            players.add(Sistema.registroOuLogin(0));
//            players.add(Sistema.registroOuLogin(1));
//            if (players.get(0).equals(players.get(1))) {
//                System.out.println("Usuários iguais! Por favor, entrem com contas diferentes.");
//            } else {
//                players.get(0).setId(0);
//                players.get(1).setId(1);
//                break;
//            }
//        }
//
//        System.out.println("Agora vamos configurar o mapa!");
//
//        Mapa mapa = Sistema.configMapa();
//        mapa.plotarMatriz();
//
//        System.out.println("\nÓtimo! Agora vamos escolher a quantidade máxima de jogadores " +
//                "por time");
//
//        Sistema.modoDeJogo();
//
//        players.get(0).escolherPersonagens();
//        players.get(1).escolherPersonagens();
//
//        players.get(0).mostrarTime();
//        players.get(1).mostrarTime();
//
//        players.get(0).selecionarConquista();
//        players.get(1).selecionarConquista();

        ArrayList<Personagem> p1 = new ArrayList<>();
        ArrayList<Personagem> p2 = new ArrayList<>();

        p1.add(new Gosminha("Gosminha", 1));
        p1.add(new Gosminha("Gosminha", 1));
        p1.add(new Gosminha("Gosminha", 1));

        p2.add(new Gosminha("Gosminha", 0));
        p2.add(new Gosminha("Gosminha", 0));
        p2.add(new Gosminha("Gosminha", 0));

        Mapa mapa = new Mapa(20, 20);
        Sistema.limitePersonagens = 3;
        mapa.organizarPersonagens(p1, p2);

        mapa.plotarMatriz();

//        players.get(0).statusDoTime();
//        players.get(1).statusDoTime();

    }

}
