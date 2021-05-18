package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

public class Fadinha extends Personagem {
   public Fadinha(String nome, int id){
         setPlayerId(id);
         setNome(nome);
         setVida(300);
         setMana(40);
         setAtk(3);
         setDef(2);
         setAgl(8);
         setSurtoAcumulado(0);
         setSurtado(false);
          sprite.setCharacter('✧');
    }
     @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com seu pozinho mágico !");
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
                System.out.println(getNome() + " atacou " + p.getNome() + "com a luz da cura!");
                System.out.println("Dano retirado: " + dano);
            } else System.out.println(p.getNome() + " desviou do ataque!");
        } else System.out.println(getNome() + " está sem mana!");
    }

    @Override
    public void ativarModoSurto() {
        modoSurto(5, 2, 0);
        passarTurno();
    }

    @Override
    public String descricao() {
        return "Ophelia é uma fada que vive na floresta escura que circundeia Barlof. Sempre muito carismática, busca ajudar a todos aqueles que pedem sua ajuda.";
    }
}
