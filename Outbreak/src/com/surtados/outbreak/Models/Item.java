package com.surtados.outbreak.Models;

import com.surtados.outbreak.components.ItemBox;

public class Item {
    private String nome;
    private String tipoDeItem;
    public Coordenada coord = new Coordenada();
    public Sprite sprite = new Sprite();
    public ItemBox itemBox;

    public Item(String tipoDeItem) {
        if (tipoDeItem.equals("ATK")) {
            setNome("Espada vermelha");
        } else if (tipoDeItem.equals("DEF")) {
            setNome("Armadura divina");
        } else if (tipoDeItem.equals("AGL")) {
            setNome("Pena da agilidade");
        } else if (tipoDeItem.equals("CURA")) {
            setNome("Poção de cura");
        } else if (tipoDeItem.equals("MANA")) {
            setNome("Poção de mana");
        }
        setTipoDeItem(tipoDeItem);
        sprite.setCharacter('$');
        sprite.setPath("E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/" + tipoDeItem.toLowerCase() + ".png");
    }

    public ItemBox getItemBox() {
        return itemBox;
    }

    public void setItemBox(ItemBox itemBox) {
        this.itemBox = itemBox;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeItem() {
        return tipoDeItem;
    }

    public void setTipoDeItem(String tipoDeItem) {
        this.tipoDeItem = tipoDeItem;
    }

    public String descricao() {
        if (getTipoDeItem().equals("ATK")) return "Espada Suprema criada por divindades milinares.\nCapaz de aumentar o ataque de quem a usa.";
        else if (getTipoDeItem().equals("DEF")) return "Escudo divino feito para proteger\ntodos aqueles que precisam.\nCapaz de aumentar a defesa de quem o usa.";
        else return "Pena especial de uma ave lendária. Poucos conseguem enxergá-la\ndevido a sua alta velocidade.\nCapaz de aumentar a agilidade de quem a usa.";
    }
}
