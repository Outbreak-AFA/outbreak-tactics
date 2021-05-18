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

    public Item getItemEspecial() {
        return itemEspecial;
    }

    public void setItemEspecial(Item itemEspecial) {
        this.itemEspecial = itemEspecial;
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
        System.out.println("ATK: " + getAtk());
        System.out.println("DEF: " + getDef());
        System.out.println("AGL: " + getAgl());
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

    public abstract String descricao();

    public String equiparItem(Item i) {
        setItemEspecial(i);
        if (i.getTipoDeItem().equals("ATK")) {
            setAtk(getAtk() * 2);
            return getNome() + " dobrou o seu ataque com " + i.getNome() + "!";
        } else if (i.getTipoDeItem().equals("DEF")) {
            setDef(getDef() * 2);
            return getNome() + " dobrou o sua defeca com " + i.getNome() + "!";
        } else if (i.getTipoDeItem().equals("AGL")) {
            setAtk(getAgl() + 2);
            return getNome() + " ganhou mais " + 2 + " pontos de agilidade com " + i.getNome() + "!";
        }
        return "Ocorreu um problema ao identificar o item :(";
    }

    private void dfs(Mapa mapa, int lin, int col, ArrayList<Coordenada> proibidos, ArrayList<Coordenada> possiveis) {
        int colMax = mapa.getColunaMax(), linMax = mapa.getLinhaMax();
        if ((lin < 0 || lin >= linMax) || (col < 0 || col >= colMax) || ((!coord.equals(lin, col)) && (!mapa.posicaoVazia(lin, col, proibidos))) || (!verificarPossiveis(possiveis, lin, col))) {
            return;
        } else {
            Coordenada co = new Coordenada();
            co.setPosicao(lin, col);
            if (!coord.equals(lin, col)) {
                System.out.println("Adicionei os possíveis: " + co.getLinha() + " " + co.getColuna());
                possiveis.add(co.clone());
            }
            dfs(mapa, (lin + 1), (col), proibidos, possiveis);
            dfs(mapa, (lin - 1), (col), proibidos, possiveis);
            dfs(mapa, (lin), (col + 1), proibidos, possiveis);
            dfs(mapa, (lin), (col - 1), proibidos, possiveis);
        }
    }

    public void printarPossiveis(ArrayList<Coordenada> possiveis) {
        for (int i=0; i<possiveis.size(); i++) {
            System.out.println("Posição [" + i + "] - " + possiveis.get(i).getLinha() + " " + possiveis.get(i).getColuna());
        }
    }

    private boolean verificarPossiveis(ArrayList<Coordenada> possiveis, int lin, int col) {
        for (Coordenada c : possiveis) {
            if (c.equals(lin, col)) return false;
        }
        return true;
    }

    private void floodFill(Mapa mapa, int lin, int col, ArrayList<Coordenada> proibidos, ArrayList<Coordenada> possiveis) {
        System.out.println("vou rodar o dfs");
        dfs(mapa, lin, col, proibidos, possiveis);
        printarPossiveis(possiveis);
        System.out.println(possiveis.size());
        System.out.println("saiu do dfs");
    }

    private ArrayList<Coordenada> getAlcanceProibido() {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        Coordenada temp = new Coordenada();
        if (getAgl() == 2) {
            //Agilidade nivel 2
            for (int lin=-2; lin<=2; lin++) {
                for (int col=-2; col<=2; col++) {
                    if (!((col == lin || col == -lin) ||
                     (col == 0 && (lin == -1 || lin == 1)) ||
                     (lin == 0 && (col == -1 || col == 1)))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
        } 
        else if (getAgl() == 4) {
            for (int lin=-2; lin<=2; lin++) {
                for (int col=-2; col<=2; col++) {
                    if (!((col == lin || col == -lin) || (lin == 0 || col == 0))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna());
            proibidos.add(temp.clone());

        }
        else if (getAgl() == 6) {
            for (int lin=-3; lin<=3; lin++) {
                for (int col=-3; col<=3; col++) {
                    if (!((col == lin || col == -lin) || (lin == 0 || col == 0) || ((lin == -3 || lin == 3) && (col == -2 || col == 2)) || (((col == -3 || col == 3) && (lin == -2 || lin == 2))))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());

        }
        else if (getAgl() == 8) {
            for (int lin=-3; lin<=3; lin++) {
                for (int col=-3; col<=3; col++) {
                    if (!(((col == lin || col == -lin) && (col != -2 && col != 2)) || (lin == 0 || col == 0) ||
                            ((lin == -3 || lin == 3) && (col == -2 || col == 2)) ||
                            (((col == -3 || col == 3) && (lin == -2 || lin == 2))) ||
                            ((lin == -2 || lin == 2) && (col == -1 || col == 1)) ||
                            ((col == -2 || col == 2) && (lin == -1 || lin == 1)))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());

        }
        else if (getAgl() == 10) {
            for (int lin=-4; lin<=4; lin++) {
                for (int col=-4; col<=4; col++) {
                    if (!(col == lin || col == -lin) &&
                        (((lin == -4 || lin == 4) && (col >= -3 || col <= 3))) ||
                        (((col == -4 || col == 4) && (lin >= -3 || lin <= 3))) ) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
        }
        return proibidos;
    }

    public ArrayList<Coordenada> getAlcance(Mapa mapa) {
        ArrayList<Coordenada> proibidos = getAlcanceProibido();
        ArrayList<Coordenada> possiveis = new ArrayList<>();
        floodFill(mapa, coord.getLinha(), coord.getColuna(), proibidos, possiveis);
        return possiveis;
    }
}
