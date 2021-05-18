package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.Personagem;

public class Gosminha extends Personagem {
   public Gosminha(String nome, int id){
         setPlayerId(id);
         setNome(nome);
         setVida(250);
         setMana(50);
         setAtk(4);
         setDef(6);
         setAgl(4);
         setSurtoAcumulado(0);
         setSurtado(false);
          sprite.setCharacter('☺');
    }
     @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " dando uma cabeçada !");
            System.out.println("Dano retirado: " + dano);
        } else {
            System.out.println(p.getNome() + " desviou do ataque!");
        }
    }

    @Override
    public void habilidadeEspecial(Personagem p) {
        // TODO Verificar range de dano
        if (getMana() > 0) {
            if (Sistema.acertou(p)) {
                int dano = calcularDano(10, p);
                dano += calcularDano(10, p);
                p.retirarVida(dano);
                setMana(getMana() - 10);
                System.out.println(getNome() + " atacou " + p.getNome() + "cuspindo veneno!");
                System.out.println("Dano retirado: " + dano);
            } else 
                System.out.println(p.getNome() + " desviou do ataque!");
            } else System.out.println(getNome() + " está sem mana!");
        }

    @Override
    public void ativarModoSurto() {
        modoSurto(5, 2, 0);
        passarTurno();
    }
    
    @Override
    public String descricao() {
        return "Gosminha é um pequeno bichinho que vive em esgotos e pantanais. Gosta de comer praticamente tudo mas não sabe  diferenciar uma maçã de um tomate.\nApesar de ser meio bobo, pode cuspir um veneno e causar grandes malefícios aos corpos daqueles que o encostam.";
    }
}
