package com.surtados.outbreak;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Mapa;
import com.surtados.outbreak.Models.Player;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();

        boolean menu = Sistema.menuJogo();
        if (!menu) {
            System.out.println("Saindo do jogo!");
            return;
        }

        System.out.println("Iniciando jogo!\n");
        while (true) {
            players.add(Sistema.registroOuLogin(0));
            players.add(Sistema.registroOuLogin(1));
            if (players.get(0).equals(players.get(1))) {
                System.out.println("Usuários iguais! Por favor, entrem com contas diferentes.");
            } else {
                break;
            }
        }

        System.out.println("Agora vamos configurar o mapa!");

        Mapa mapa = Sistema.configMapa();
        mapa.plotarMatriz();
    }

}
