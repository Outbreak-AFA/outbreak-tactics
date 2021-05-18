package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Personagem;

import java.util.ArrayList;

public class Gosminha extends Personagem {
   public Gosminha(String nome, int id, Player p){
       super(p);
       setPlayerId(id);
         setNome(nome);
         setVida(250);
         setMana(50);
         setAtk(4);
         setDef(6);
         setAgl(4);
         setSurtoAcumulado(0);
         setSurtado(false);
         setAtkNatural("Cabeçada");
         setHabilidadeEspecial("Cuspir veneno");
          sprite.setCharacter('☺');
    }
     @Override
    public void atacarNatural(Personagem p) {
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " dando uma cabeçada !");
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
                System.out.println(getNome() + " atacou " + p.getNome() + " cuspindo veneno!");
                System.out.println("Dano retirado: " + dano);
                aumentarSurto(dano);
                p.aumentarSurto(dano);
            } else
                System.out.println(p.getNome() + " desviou do ataque!");
            } else System.out.println(getNome() + " está sem mana!");
        }

    @Override
    public void ativarModoSurto() {
        modoSurto(15, 30, 2);
    }
    
    @Override
    public String descricao() {
        return "Gosminha é um pequeno bichinho que vive em esgotos e pantanais. Gosta de comer praticamente tudo mas não sabe  diferenciar uma maçã de um tomate.\nApesar de ser meio bobo, pode cuspir um veneno e causar grandes malefícios aos corpos daqueles que o encostam.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        if (opcao == 1) {
            Coordenada temp = new Coordenada();

            temp.setPosicao(coord.getLinha(), coord.getColuna() - 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 2, coord.getColuna());
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha(), coord.getColuna() + 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 2, coord.getColuna());
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 1);
            proibidos.add(temp.clone());
        }
        else {
            Coordenada temp = new Coordenada();

            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 3);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 3);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 3);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 3);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());
        }
        return proibidos;
    }
}
