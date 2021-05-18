package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Utils.Dados;

import java.util.ArrayList;

public class Fadinha extends Personagem {
   public Fadinha(String nome, int id, Player p){
       super(p);
         setPlayerId(id);
         setNome(nome);
         setVida(300);
         setMana(100);
         setAtk(3);
         setDef(2);
         setAgl(8);
         setSuporte(true);
         setAtkNatural("Pózinho mágico");
         setHabilidadeEspecial("Luz da cura");
         setSurtoAcumulado(0);
         setSurtado(false);
          sprite.setCharacter('✧');
    }
     @Override
    public void atacarNatural(Personagem p) {
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com seu pozinho mágico !");
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
            int cura = Dados.random(20) + Dados.random(20);
            setMana(getMana() - 10);
            p.setVida(p.getVida() + cura);
            System.out.println(getNome() + " curou " + cura + " pontos de vida de " + p.getNome() + "  com a luz da cura!");
            aumentarSurto(cura);
            p.aumentarSurto(cura);
        } else System.out.println(getNome() + " está sem mana!");
    }

    @Override
    public void ativarModoSurto() {
        modoSurto(7, 20, 2);
    }

    @Override
    public String descricao() {
        return "Ophelia é uma fada que vive na floresta escura que circundeia Barlof. Sempre muito carismática, busca ajudar a todos aqueles que pedem sua ajuda.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        Coordenada temp = new Coordenada();

        if (opcao == 1) {
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
}
