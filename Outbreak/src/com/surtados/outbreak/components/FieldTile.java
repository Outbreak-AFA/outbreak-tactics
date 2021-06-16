package com.surtados.outbreak.components;

import com.surtados.outbreak.Models.*;
import javafx.scene.layout.VBox;

public class FieldTile extends VBox {
    public Coordenada coordenada = new Coordenada();
    public Item item;
    public Obstaculo obstaculo;
    public Personagem personagem;
    private String estilo;

    private String concatenaIcon(String str) {
        String path = str.substring(90);
        String novoCaminho = "icon-".concat(path);
        novoCaminho = "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/" + novoCaminho;
        return novoCaminho;
    }

    public FieldTile() {
        setEstilo("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-color: transparent;");
        item = null;
        obstaculo = null;
        personagem = null;
        setStyle(getEstilo());
    }

    public FieldTile(Personagem p) {
        setEstilo("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-color: transparent; " + "-fx-background-image: url('file:///" + concatenaIcon(p.sprite.getPath()) + "');");
        item = null;
        obstaculo = null;
        personagem = p;
        setStyle(getEstilo());
    }

    public FieldTile(Item i) {
       setEstilo("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-color: transparent; " + "-fx-background-image: url('file:///" + i.sprite.getPath() + "');");
        item = i;
        obstaculo = null;
        personagem = null;
        setStyle(getEstilo());
    }

    public FieldTile(Obstaculo o) {
        setEstilo("-fx-border-radius: 5px; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-width: 30px; -fx-max-height: 30px; -fx-background-color: transparent; " + "-fx-background-image: url('file:///" + o.sprite.getPath() + "');");
        item = null;
        obstaculo = o;
        personagem = null;
        setStyle(getEstilo());
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Obstaculo getObstaculo() {
        return obstaculo;
    }

    public void setObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void substituir(FieldTile fieldTile) {
        setPersonagem(fieldTile.getPersonagem());
        setStyle(fieldTile.getEstilo());
        setObstaculo(fieldTile.getObstaculo());
        setItem(fieldTile.getItem());
        setEstilo(fieldTile.getEstilo());
    }
}
