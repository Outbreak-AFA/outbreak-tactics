package com.surtados.outbreak.Models;

import com.surtados.outbreak.Utils.Sistema;

public class Pyromancer extends Personagem {
    public Pyromancer(String nome) {
        setNome(nome);
        setAtk(5);
        setDef(4);
        setAgl(3);
        setMana(50);
        setVida(250);
        setSurtado(false);
        setSurtoAcumulado(0);
    }

    @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(8, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com seu cajado flamejante!");
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
                System.out.println(getNome() + " atacou " + p.getNome() + "com bolas flamejantes!");
                System.out.println("Dano retirado: " + dano);
            } else {
                System.out.println(p.getNome() + " desviou do ataque!");
            }
        } else System.out.println(getNome() + " está sem mana!");
    }

    @Override
    public void ativarModoSurto() {
        modoSurto(5, 2, 0);
        passarTurno();
    }
}
