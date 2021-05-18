package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

import java.util.ArrayList;

public class Gengah extends Personagem {
    public Gengah(String nome, int id, Player p){
        super(p);
        setPlayerId(id);
        setNome(nome);
        setAtk(4);
        setDef(5);
        setAgl(8);
        setMana(70);
        setVida(300);
        setSurtado(false);
        setSurtoAcumulado(0);
        setAtkNatural("Arranhar");
        setHabilidadeEspecial("Bola sombria");
        sprite.setCharacter('☪');
    }

    @Override
    public void atacarNatural(Personagem p) {
        if (Sistema.acertou(p)) {
            int dano = calcularDano(6, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com suas garras!");
            System.out.println("Dano retirado: " + dano);
            aumentarSurto(dano);
            p.aumentarSurto(dano);
        } else {
            System.out.println(p.getNome() + " desviou do ataque!");
        }
    }

    @Override
    public void habilidadeEspecial(Personagem p) {
        if (getMana() > 0) {
            if (Sistema.acertou(p)) {
                int dano = calcularDano((3*getAtk()), p);
                p.retirarVida(dano);
                setMana(getMana() - 10);
                System.out.println(getNome() + " atacou " + p.getNome() + " com suas esferas sobrias!");
                System.out.println("Dano retirado: " + dano);
                aumentarSurto(dano);
                p.aumentarSurto(dano);
            } else {
                System.out.println(p.getNome() + " desviou do ataque!");
            }
        } else System.out.println(getNome() + " está sem mana!");
    }

    @Override
    public void ativarModoSurto() {
        modoSurto(30, 2, 2);
    }

    @Override
    public String descricao() {
        return "Gengah é um ser místico que vive nas sombras desde o início dos tempos." +
                "\nSua aparência felina encanta muitas pessoas que chegam a cruzar seu caminho, " +
                "porém, não se engane...\nÀs vezes os frascos mais bonitos possuem os piores venenos.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        if (opcao == 1) {
            Coordenada temp = new Coordenada();

            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 1);
            proibidos.add(temp.clone());

        }
        else {
            Coordenada temp = new Coordenada();

            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna()  +1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 3);
            proibidos.add(temp.clone());
        }
        return proibidos;
    }
}
