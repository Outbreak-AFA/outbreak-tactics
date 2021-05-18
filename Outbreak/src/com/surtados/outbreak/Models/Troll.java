package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

public class Troll extends Personagem {
        public Troll(String nome, int id){
         setPlayerId(id);
         setNome(nome);
         setVida(200);
         setMana(60);
         setAtk(6);
         setDef(5);
         setAgl(2);
         setSurtoAcumulado(0);
         setSurtado(false);
         sprite.setCharacter('T');
    }
     @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com seu martelo!");
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
                System.out.println(getNome() + " atacou " + p.getNome() + "com seu super soco!");
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
            return "Troll é um ogro muito raivoso que vive nas cavernas próximas às montanhas distantes de Barlof. Sortudo é aquele que consegue fugir de seu ataque, apesar de não ser tão difícil correr de sua lentidão.";
    }
}
