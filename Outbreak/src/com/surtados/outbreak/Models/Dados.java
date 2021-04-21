package com.surtados.outbreak.Models;



public class Dados {

    // 1d6
    public static int random() {
        int rdm = 1 + (int) (Math.random() * 6);
        return rdm;
    }

    // 1dx
    public static int random(int max) {
        int rdm = 1 + (int) (Math.random() * max);
        return rdm;
    }

    // 1dx + y
    public static int random(int max, int modifier) {
        int rdm = 1 + (int) (Math.random() * max);
        return rdm + modifier;
    }
}
