package com.surtados.outbreak;

import com.surtados.outbreak.Core.Sistema;

public class App {

    public static void main(String[] args) {
        boolean menu = Sistema.menuJogo();
        if (!menu) {
            System.out.println("Saindo do jogo!");
            return;
        }
        System.out.println("Iniciando jogo!");
    }

}
