package com.surtados.outbreak.Models;

public class Pyromancer extends Personagem {
    public Pyromancer(String nome) {
        setAtk(5);
        setDef(4);
        setAgl(3);
        setMana(50);
        setVida(350);
        setSurtado(false);
        setSurtoAcumulado(0);
    }

    @Override
    public void atacarNatural(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(6);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + "com seu cachado flamejante!");
        } else {
            System.out.println(p.getNome() + " desviou do ataque!");
        }
    }

    @Override
    public void habilidadeEspecial(Personagem p) {
        // TODO Verificar range de dano
        if (Sistema.acertou(p)) {
            int dano = calcularDano(10);
            dano += calcularDano(10);
            p.retirarVida(dano);
            System.out.println(getNome() + " atacou " + p.getNome() + "com bolas flamejantes!");
        } else {
            System.out.println(p.getNome() + " desviou do ataque!");
        }
    }

    @Override
    public void modoSurto() {}
}
