package com.surtados.outbreak.Models;

import com.surtados.outbreak.Utils.Sistema;

public class Gengah extends Personagem {
    public Gengah(String nome) {
        setNome(nome);
        setAtk(4);
        setDef(5);
        setAgl(8);
        setMana(70);
        setVida(300);
        setSurtado(false);
        setSurtoAcumulado(0);
    }

    @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(6, p);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + " com suas garras!");
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
                int dano = calcularDano((3*getAtk()), p);
                p.retirarVida(dano);
                setMana(getMana() - 10);
                System.out.println(getNome() + " atacou " + p.getNome() + "com suas esferas sobrias!");
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
