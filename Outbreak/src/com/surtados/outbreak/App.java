package com.surtados.outbreak;

import com.surtados.outbreak.Models.*;

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
//
//        players.get(0).statusDoTime();
//        players.get(1).statusDoTime();

        Mapa mapa = new Mapa(20, 20);


        Fadinha f = new Fadinha("Ophelia", 1);
        f.coord.setPosicao(10, 10);

        LapaGod lg = new LapaGod("Lapa", 1);
        lg.coord.setPosicao(1, 1);
        lg.equiparItem(new Item("AGL"));

        mapa.inserirPersonagem(lg);

        Obstaculo obs = new Obstaculo('X');
        Obstaculo arroba = new Obstaculo('@');

        arroba.coord.setPosicao(9, 8);
        mapa.inserirObsetaculo(arroba.clone());

        arroba.coord.setPosicao(9, 9);
        mapa.inserirObsetaculo(arroba.clone());

        arroba.coord.setPosicao(9, 10);
        mapa.inserirObsetaculo(arroba.clone());

        arroba.coord.setPosicao(9, 11);
        mapa.inserirObsetaculo(arroba.clone());

        arroba.coord.setPosicao(9, 12);
        mapa.inserirObsetaculo(arroba.clone());

        mapa.inserirPersonagem(f);

        System.out.println();
        for (Coordenada cp : lg.getAlcance(mapa)) {
            System.out.println(cp.getLinha() + " " + cp.getColuna());
            obs.coord.setPosicao(cp.getLinha(), cp.getColuna());
            mapa.inserirObsetaculo(obs);
        }

        mapa.plotarMatriz();
    }

}
