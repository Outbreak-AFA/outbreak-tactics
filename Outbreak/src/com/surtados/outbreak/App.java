package com.surtados.outbreak;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.*;

import java.util.ArrayList;
import java.util.Scanner;

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
                players.get(0).setId(0);
                players.get(1).setId(1);
                break;
            }
        }

        while (true) {
            System.out.println("Agora vamos configurar o mapa!");

            Mapa mapa = Sistema.configMapa();

            System.out.println("\nÓtimo! Agora vamos escolher a quantidade máxima de jogadores " +
                    "por time");

            Sistema.modoDeJogo();

            players.get(0).escolherPersonagens();
            players.get(1).escolherPersonagens();

            players.get(0).mostrarTime();
            players.get(1).mostrarTime();

            players.get(0).selecionarConquista();
            players.get(1).selecionarConquista();

            Sistema.sortearPlayers(players);

            mapa.organizarPersonagens(players.get(0).time, players.get(1).time);

            int rodada = 0;
            while (!players.get(0).perdeu(mapa) && !players.get(1).perdeu(mapa)) {
                mapa.plotarMatriz();
                players.get(rodada).listarTime(mapa);
                if (rodada == 0) {
                    rodada = 1;
                } else rodada = 0;
            }
            if (!players.get(0).perdeu(mapa)) {
                System.out.println("Parabéns " + players.get(0).getNome() + "!!! Você ganhou!");
                players.get(0).setVitorias(players.get(0).getVitorias() + 1);
                players.get(1).setDerrotas(players.get(1).getDerrotas() + 1);
            }

            else if (!players.get(1).perdeu(mapa)) {
                System.out.println("Parabéns " + players.get(1).getNome() + "!!! Você ganhou!");
                players.get(1).setVitorias(players.get(1).getVitorias() + 1);
                players.get(0).setDerrotas(players.get(0).getDerrotas() + 1);
            }
            System.out.print("Desejam jogar novamente? (s | n)\n>>> ");
            Scanner scan = new Scanner(System.in);
            String sn = scan.nextLine();
            if (!sn.toLowerCase().equals("s")) {
                break;
            } else System.out.println("Tudo bem! Recomeçando...");
        }
    }

}
