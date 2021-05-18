package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

public class MrCanhao extends Personagem {
        public MrCanhao(String nome, int id){
            setPlayerId(id);
            setNome(nome);
            setVida(250);
            setMana(40);
            setAtk(5);
            setDef(4);
            setAgl(4);
            setSurtoAcumulado(0);
            setSurtado(false);
            sprite.setCharacter('§');
        }
        @Override
        public void atacarNatural(Personagem p) {
            // TODO Verificar range de dano
            if (Sistema.acertou(p)) {
                int dano = calcularDano(8, p);
                p.retirarVida(dano);
                System.out.println(getNome() + " atacou " + p.getNome() + " batendo!");
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
                    System.out.println(getNome() + " atacou " + p.getNome() + "atirando bombas");
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
        return "Mr. Canhão, ou como se chamava: Lapoleão, era um antigo guerreiro que se destacou em guerras, pelo menos\nenquanto era humano, antes de ser enfeitiçado por uma bruxa e ser transformado em um canhão. Mesmo assim,\nMr. Canhão é ainda um importante participante de batalhas, podendo atingir longas distâncias com seus ataques.";
    }

}
