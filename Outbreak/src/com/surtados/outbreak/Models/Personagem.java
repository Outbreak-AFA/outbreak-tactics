package com.surtados.outbreak.Models;

import com.surtados.outbreak.Utils.Coordenada;
import com.surtados.outbreak.Utils.Dados;

import java.util.ArrayList;

public abstract class Personagem {
    private String nome;
    private int vida, mana, atk, def, agl;
    private int surtoAcumulado;
    private boolean surtado;
    public Coordenada coord;
    public ArrayList<Item> inventario;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAgl() {
        return agl;
    }

    public void setAgl(int agl) {
        this.agl = agl;
    }

    public int getSurtoAcumulado() {
        return surtoAcumulado;
    }

    public void setSurtoAcumulado(int surtoAcumulado) {
        this.surtoAcumulado = surtoAcumulado;
    }

    public boolean isSurtado() {
        return surtado;
    }

    public void setSurtado(boolean surtado) {
        this.surtado = surtado;
    }

    public abstract void atacarNatural(Personagem p);
    public abstract void habilidadeEspecial(Personagem p);
    public abstract void modoSurto();

    public void andar(int x, int y) {
        System.out.println(this.getNome() + " andou " + x + " e " + y);
    }

    public void retirarVida(int dano) {
        setVida(getVida() - dano);
    }

    public int calcularDano(int danoTomado) {
        int probabilidade = Dados.random(20);
        int dano = getAtk() * Dados.random(danoTomado);
        if (probabilidade >= 19) dano *= getAtk();
        return dano;
    }

    public void mostrarStatus() {
        System.out.println("========="+ getNome() +"=========");
        System.out.println("Vida: " + getVida());
        System.out.println("Mana: " + getMana());
        System.out.println("Surto acumulado: " + getSurtoAcumulado());
        System.out.println("=======================================");
    }

    public boolean morreu() {
        if (getVida() > 0) return false;
        return true;
    }

}
