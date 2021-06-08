package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

import java.util.ArrayList;

public class LapaGod extends Personagem {
    public LapaGod(String nome, int id, Player p){
        super(p);
        setPlayerId(id);
        setNome(nome);
        setVida(300);
        setMana(50);
        setAtk(999);
        setDef(10);
        setAgl(8);
        setAtkNatural("Motivar");
        setHabilidadeEspecial("C#");
        setSurtoAcumulado(0);
        setSurtado(false);
        sprite.setCharacter('♔');
    }
    @Override
    public void atacarNatural(Personagem p) {
        System.out.println(getNome() + " motivou " + p.getNome());
    }

    @Override
    public void habilidadeEspecial(Personagem p) {
        if (getMana() > 0) {
            if (Sistema.acertou(p)) {
                int dano = calcularDano(10, p);
                dano += calcularDano(10, p);
                p.retirarVida(dano);
                setMana(getMana() - 10);
                System.out.println(getNome() + " atacou " + p.getNome() + " usando o C#!");
                System.out.println("Dano retirado: " + dano);
                aumentarSurto(dano);
                p.aumentarSurto(dano);
            } else System.out.println(p.getNome() + " desviou do ataque!");
        } else System.out.println(getNome() + " está sem mana!");
    }


    @Override
    public void ativarModoSurto() {
        modoSurto(0, 0, 0);
    }

    @Override
    public String descricao() {
        return "O que?? PARABÉNS!!! Você acessou o personagem mais supremo deste universo.\nLapa é o bruxo mais poderoso do C# capaz de destruir qualquer criatura em questão de segundos.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        return new ArrayList<Coordenada>();
    }
}
