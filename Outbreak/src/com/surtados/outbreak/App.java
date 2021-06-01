package com.surtados.outbreak;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("first_page.fxml"));
        primaryStage.setTitle("Outbreak Tactics");
        primaryStage.setResizable(false);

        String firstPageCSS = getClass().getResource("./Styles/first_page.css").toExternalForm();

        Scene cena = new Scene(root, 800, 600);
        cena.getStylesheets().add(firstPageCSS);
        cena.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P");

        primaryStage.setScene(cena);
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//
//
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
//        while (true) {
//            System.out.println("Agora vamos configurar o mapa!");
//
//            Mapa mapa = Sistema.configMapa();
//
//            System.out.println("\nÓtimo! Agora vamos escolher a quantidade máxima de jogadores " +
//                    "por time");
//
//            Sistema.modoDeJogo();
//
//            players.get(0).escolherPersonagens();
//            players.get(1).escolherPersonagens();
//
//            players.get(0).mostrarTime();
//            players.get(1).mostrarTime();
//
//            players.get(0).selecionarConquista();
//            players.get(1).selecionarConquista();
//
//            Sistema.sortearPlayers(players);
//
//            mapa.organizarPersonagens(players.get(0).time, players.get(1).time);
//
//            Item i = new Item("CURA");
//            Item cura = new Item("CURA");
//            Item i_ = new Item("MANA");
//            i.coord.setPosicao(6, 2);
//            i_.coord.setPosicao(6, 18);
//            cura.coord.setPosicao(4, 9);
//            mapa.inserirItem(i);
//            mapa.inserirItem(i_);
//            mapa.inserirItem(cura);
//
//            int rodada = 0;
//            while (!players.get(0).perdeu(mapa) && !players.get(1).perdeu(mapa)) {
//                mapa.plotarMatriz();
//                players.get(rodada).listarTime(mapa);
//                if (rodada == 0) {
//                    rodada = 1;
//                } else rodada = 0;
//            }
//            if (!players.get(0).perdeu(mapa)) {
//                System.out.println("Parabéns " + players.get(0).getNome() + "!!! Você ganhou!");
//                players.get(0).setVitorias(players.get(0).getVitorias() + 1);
//                players.get(1).setDerrotas(players.get(1).getDerrotas() + 1);
//            }
//
//            else if (!players.get(1).perdeu(mapa)) {
//                System.out.println("Parabéns " + players.get(1).getNome() + "!!! Você ganhou!");
//                players.get(1).setVitorias(players.get(1).getVitorias() + 1);
//                players.get(0).setDerrotas(players.get(0).getDerrotas() + 1);
//            }
//            System.out.print("Desejam jogar novamente? (s | n)\n>>> ");
//            Scanner scan = new Scanner(System.in);
//            String sn = scan.nextLine();
//            if (!sn.toLowerCase().equals("s")) {
//                break;
//            } else System.out.println("Tudo bem! Recomeçando...");
//        }
//    }

}
