package com.surtados.outbreak.Models;

import com.surtados.outbreak.Utils.Dados;

public class Item {
    private String tipoDeItem;

    public String getTipoDeItem() {
        return tipoDeItem;
    }

    public void setTipoDeItem(String tipoDeItem) {
        this.tipoDeItem = tipoDeItem;
    }

    public String usarItem(Personagem p) {
        int valorDados = Dados.random(20) + Dados.random(20) + Dados.random(20);
        switch (this.getTipoDeItem()) {
            case "MANA":
                p.setMana(p.getMana() + valorDados);
                return p.getNome() + " recuperou " + valorDados + " de mana!";
            case "CURA":
                p.setVida(p.getVida() + valorDados);
                return p.getNome() + " recuperou " + valorDados + " de vida!";
            case "DEF":
                p.setDef(p.getDef() + (int)(p.getDef() / 2));
                return p.getNome() + " ganhou mais " + (p.getDef() + (int)(p.getDef() / 2)) + " de defesa!";
            case "ATK":
                p.setAtk(p.getAtk() + (int)(p.getAtk() / 2));
                return p.getNome() + " ganhou mais " + (p.getAtk() + (int)(p.getAtk() / 2)) + " de ataque!";
            default:
                p.setAtk(p.getAgl() + (int)(p.getAgl() / 2));
                return p.getNome() + " ganhou mais " + (p.getAgl() + (int)(p.getAgl() / 2)) + " de agilidade!";
        }
    }
}
