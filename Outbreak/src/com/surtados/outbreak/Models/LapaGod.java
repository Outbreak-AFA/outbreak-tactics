package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

public class LapaGod extends Personagem {
   public LapaGod(String nome, int id){
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
        // TODO Verificar range de dano
        System.out.println(getNome() + " motivou " + p.getNome());
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
                System.out.println(getNome() + " atacou " + p.getNome() + "usando o C#!");//??
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
        return "O que?? PARABÉNS!!! Você acessou o personagem mais supremo deste universo.\nLapa é o bruxo mais poderoso do C# capaz de destruir qualquer criatura em questão de segundos.";
    }
}
