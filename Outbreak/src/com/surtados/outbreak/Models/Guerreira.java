package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

public class Guerreira extends Personagem{
    public Guerreira(String nome, int id){
         setPlayerId(id);
        setNome(nome);
         setVida(200);
         setMana(50);
         setAtk(5);
         setDef(4);
         setAgl(6);
         setSurtoAcumulado(0);
         setSurtado(false);
          sprite.setCharacter('╁');
    }
     @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com sua espada!");
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
                System.out.println(getNome() + " atacou " + p.getNome() + "com seu escudo mágico!");
                System.out.println("Dano retirado: " + dano);
            } else System.out.println(p.getNome() + " desviou do ataque!");
        } else System.out.println(getNome() + " está sem mana!");
    }


    @Override
    public void ativarModoSurto() {
        modoSurto(5, 2, 0);
        //passarTurno();
    }

    @Override
    public String descricao() {
        return "Alice era uma pequena princesa filha do rei das terras de Barlof. Mas, com a sua personalidade extremamente forte, não aceitava determinadas ordens, o que a levou a quebrar uma importante cláusula do Índice de Regras Reais em sua\ninfância. Devido a isso, Alice foi expulsa de seu reino, fugindo para as montanhas, onde chegou a treinar com um velho Guerreiro que a ensinou como manusear espadas.\nHoje, Alice busca se tornar forte o suficiente para libertar seu povo das maldades do reino que vivera.";
    }
}
