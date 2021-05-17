package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Utils.Dados;

import java.util.ArrayList;

public abstract class Personagem {
    private int playerId;
    public Sprite sprite = new Sprite();
    private String nome;
    private int vida, mana, atk, def, agl;
    private double surtoAcumulado;
    private boolean surtado = false;
    private int contadorSurto;
    public Coordenada coord = new Coordenada();
    public ArrayList<Item> inventario = new ArrayList<>();
    private Item itemEspecial;

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

    public double getSurtoAcumulado() {
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

    public int getContadorSurto() {
        return contadorSurto;
    }

    public void setContadorSurto(int contadorSurto) {
        this.contadorSurto = contadorSurto;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public abstract void atacarNatural(Personagem p);
    public abstract void habilidadeEspecial(Personagem p);

    public void modoSurto(int atk, int def, int agl) {
        if (podeSurtar()) {
            System.out.println(getNome() + " ativou o modo surto!");
            setAtk(getAtk() + atk); setDef(getDef() + def); setAgl(getAgl() + agl);
            setSurtado(true);
            setContadorSurto(3);
            setSurtoAcumulado(0);
        } else System.out.println(getNome() + " não está com o modo surto disponível!\n" + "Faltam: " + (50 - getSurtoAcumulado()));
    }

    public void passarTurno() {
        if(getContadorSurto() > 0) setContadorSurto(getContadorSurto() - 1);
    }

    public void andar(int x, int y) {
        System.out.println(this.getNome() + " andou " + x + " e " + y);
    }

    public void retirarVida(int dano) {
        setVida(getVida() - dano);
    }

    public int calcularDano(int danoMaximoOferecido, Personagem p) {
        int probabilidadeCritico = Dados.random(20);
        int probabilidadeDefesa = Dados.random(20);
        // calcular o dano máximo possível

        int dano = getAtk() * Dados.random(danoMaximoOferecido);
        if (probabilidadeCritico >= 19) dano *= getAtk();

        // calcular dano com a defesa
        if (probabilidadeDefesa >= 19) {
            dano -= Math.pow(p.getDef(), 2);
        } else if (probabilidadeDefesa >= 10) {
            dano -= p.getDef();
        } else dano -= (int)(p.getDef() / 2);

        if (dano < 0) dano = 0;

        return dano;
    }

    public abstract void ativarModoSurto();

    public boolean podeSurtar() {
        if (getSurtoAcumulado() >= 50) return true;
        return false;
    }

    public void aumentarSurto(int danoRecebido) {
        setSurtoAcumulado(danoRecebido * Dados.random(4) / 10);
    }

    public void mostrarStatus() {
        System.out.println("========="+ getNome() +"=========");
        System.out.println("Vida: " + getVida());
        System.out.println("Mana: " + getMana());
        System.out.println("Surto acumulado: " + getSurtoAcumulado());
        System.out.println("=======================================");
    }

    public void listarItens() {
        for (Item i : inventario) {
            System.out.println(inventario.indexOf(i) + ": " + i.getTipoDeItem());
        }
    }

    public String usarItem(int index) {
        int valorDados = Dados.random(20) + Dados.random(20) + Dados.random(20);
        switch (inventario.get(index).getTipoDeItem()) {
            case "MANA":
                setMana(getMana() + valorDados);
                return getNome() + " recuperou " + valorDados + " de mana!";
            case "CURA":
                setVida(getVida() + valorDados);
                return getNome() + " recuperou " + valorDados + " de vida!";
            case "DEF":
                setDef(getDef() + (int)(getDef() / 2));
                return getNome() + " ganhou mais " + (getDef() + (int)(getDef() / 2)) + " de defesa!";
            case "ATK":
                setAtk(getAtk() + (int)(getAtk() / 2));
                return getNome() + " ganhou mais " + (getAtk() + (int)(getAtk() / 2)) + " de ataque!";
            default:
                setAtk(getAgl() + (int)(getAgl() / 2));
                return getNome() + " ganhou mais " + (getAgl() + (int)(getAgl() / 2)) + " de agilidade!";
        }
    }

    public boolean morreu() {
        if (getVida() > 0) return false;
        setVida(0);
        return true;
    }

    public void mover(int linha, int coluna, Mapa mapa) {
        mapa.setMatriz(sprite.getCharacter(), linha, coluna, coord.getLinha(), coord.getColuna());
        coord.setPosicao(linha, coluna);
    }

    public void mostrarAlcance(Mapa mapa) {
        for (Coordenada c : Sistema.getAlcance(this, mapa)) {
            System.out.println("Linha: " + c.getLinha() + " Coluna: " + c.getColuna());
        }
    }

    public abstract String descricao();

}
