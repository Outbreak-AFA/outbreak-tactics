package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

import java.util.ArrayList;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome, int id, Player p){
        super(p, "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/arqueiro.png");
        setPlayerId(id);
        setNome(nome);
        setVida(350);
        setMana(60);
        setAtk(10);
        setDef(4);
        setAgl(6);
        setAtkNatural("Atirar dardos");
        setHabilidadeEspecial("Atirar flechas");
        setSurtoAcumulado(0);
        setSurtado(false);
        sprite.setCharacter('➶');
    }

    @Override
    public void atacarNatural(Personagem p) {
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com dardos !");
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
                int dano = calcularDano(10, p);
                dano += calcularDano(10, p);
                p.retirarVida(dano);
                setMana(getMana() - 10);
                System.out.println(getNome() + " atacou " + p.getNome() + " atirando uma flecha!");
                System.out.println("Dano retirado: " + dano);
                aumentarSurto(dano);
                p.aumentarSurto(dano);
            } else System.out.println(p.getNome() + " desviou do ataque!");
        } else System.out.println(getNome() + " está sem mana!");
    }

    @Override
    public void ativarModoSurto() {
        modoSurto(20, 2, 2);
    }

    @Override
    public String descricao() {
        return "Arqueiro treinado no reino das terras de Barlof.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        Coordenada temp = new Coordenada();

        if (opcao == 1) {
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
        } else {
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() + 4);
            proibidos.add(temp.clone());
        }
        return proibidos;
    }
}
