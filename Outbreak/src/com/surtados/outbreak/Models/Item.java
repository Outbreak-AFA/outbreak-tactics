package com.surtados.outbreak.Models;

public class Item {
    private String nome;
    private String tipoDeItem;
    public Coordenada coord = new Coordenada();
    public Sprite sprite = new Sprite();

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
}
