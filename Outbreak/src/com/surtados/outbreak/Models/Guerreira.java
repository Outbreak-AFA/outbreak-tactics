package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

import java.util.ArrayList;

public class Guerreira extends Personagem{
    public Guerreira(String nome, int id, Player p){
        super(p, "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/alice.png");
         setPlayerId(id);
        setNome(nome);
         setVida(200);
         setMana(50);
         setAtk(15);
         setDef(7);
         setAgl(6);
         setSuporte(true);
         setSurtoAcumulado(0);
         setSurtado(false);
         setAtkNatural("Atacar com espada");
         setHabilidadeEspecial("Escudo mágico");
          sprite.setCharacter('╁');
    }
     @Override
    public void atacarNatural(Personagem p) {
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com sua espada!");
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
                p.setDef(p.getDef() + getDef());
                setMana(getMana() - 10);
                System.out.println(getNome() + " conjurou um escudo celestial em " + p.getNome() + ", aumentando " + getDef() + " pontos de defesa!");
        } else System.out.println(getNome() + " está sem mana!");
    }

    @Override
    public void ativarModoSurto() {
        modoSurto(25, 25, 2);
    }

    @Override
    public String descricao() {
        return "Alice era uma pequena princesa filha do rei das terras de Barlof. Mas, com a sua personalidade extremamente forte, não aceitava determinadas ordens,\n o que a levou a quebrar uma importante cláusula do Índice de Regras Reais em sua\ninfância. Devido a isso, Alice foi expulsa de seu reino,\nfugindo para as montanhas, onde chegou a treinar com um velho Guerreiro que a ensinou como manusear espadas.\nHoje, Alice busca se tornar forte o suficiente para libertar seu povo das maldades do reino que vivera.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtk(int opcao, Mapa mapa) {
        ArrayList<Coordenada> proibidos = getAlcanceAtkProibido(opcao);
        ArrayList<Coordenada> possiveis = new ArrayList<>();
        preenchimentoPorInundacao(mapa, coord.getLinha(), coord.getColuna(), proibidos, possiveis, false);
        if (opcao == 2) {
            Coordenada c = new Coordenada();
            c.setPosicao(coord.getLinha(), coord.getColuna());
            possiveis.add(c);
        }
        return possiveis;
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        if (opcao == 1) {
            Coordenada temp = new Coordenada();

            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() + 2);
            proibidos.add(temp.clone());
        }
        else {
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
        return proibidos;
    }
}
