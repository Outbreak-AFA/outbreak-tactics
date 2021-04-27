package com.surtados.outbreak.Models;

public class Sistema {
    public static boolean acertou() {
        int valor = Dados.random(20);
        if (valor >= 12) return true;
        return false;
    }

    public static boolean acertou(Personagem p) {
        int valor = Dados.random(20, p.getAgl() * (-1));
        if (valor >= 12) return  true;
        return false;
    }
}
