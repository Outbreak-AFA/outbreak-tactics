package com.surtados.outbreak.Core;

import java.util.Scanner;

public class Menu {

    public static void menuJogo() {
        System.out.println("======= OUTBREACK TACTICS ======");
        System.out.println("================================");
        System.out.println("[1] - Iniciar jogo");
        System.out.println("[2] - Instruções");
        System.out.println("[3] - Créditos");
        System.out.println("[4] - Sair");
        System.out.println("================================");

        Scanner scan = new Scanner(System.in);
        final int opcao = scan.nextInt();


        switch (opcao) {
            case 1:
                return;
            case 2:
                return;
            case 3:
                return;
            case 4:
                return;
            default:
                System.out.println("Comando inválido!");
        }
    }

}
