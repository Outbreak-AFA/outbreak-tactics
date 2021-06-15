package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;

import java.util.ArrayList;

public class MrCanhao extends Personagem {
        public MrCanhao(String nome, int id, Player p){
            super(p, "E:/Dev/Faculdade/LP1/Trabalhos/outbreak-tactics/Outbreak/src/com/surtados/outbreak/Assets/mrcanhao.png");
            setPlayerId(id);
            setNome(nome);
            setVida(250);
            setMana(40);
            setAtk(5);
            setDef(4);
            setAgl(4);
            setSurtoAcumulado(0);
            setSurtado(false);
            setAtkNatural("Bater");
            setHabilidadeEspecial("Atirar bomba");
            sprite.setCharacter('§');
        }
        @Override
        public void atacarNatural(Personagem p) {
            if (Sistema.acertou(p)) {
                int dano = calcularDano(8, p);
                p.retirarVida(dano);
                System.out.println(getNome() + " atacou " + p.getNome() + " batendo!");
                System.out.println("Dano retirado: " + dano);
                aumentarSurto(dano);
                p.aumentarSurto(dano);
            } else {
                System.out.println(p.getNome() + " desviou do ataque!");
            }
        }

        @Override
        public void habilidadeEspecial(Personagem p) {
            if (getMana() > 0) {
                if (Sistema.acertou(p)) {
                    int dano = calcularDano(10, p);
                    dano += calcularDano(10, p);
                    p.retirarVida(dano);
                    setMana(getMana() - 10);
                    System.out.println(getNome() + " atacou " + p.getNome() + " atirando bombas");
                    System.out.println("Dano retirado: " + dano);
                    aumentarSurto(dano);
                    p.aumentarSurto(dano);
                } else
                    System.out.println(p.getNome() + " desviou do ataque!");
            } else System.out.println(getNome() + " está sem mana!");
        }

    @Override
    public void ativarModoSurto() {
        modoSurto(15, 40, 2);
    }

    @Override
    public String descricao() {
        return "Mr. Canhão, ou como se chamava: Lapoleão, era um antigo guerreiro que se destacou em guerras, pelo menos\nenquanto era humano, antes de ser enfeitiçado por uma bruxa e ser transformado em um canhão. Mesmo assim,\nMr. Canhão é ainda um importante participante de batalhas, podendo atingir longas distâncias com seus ataques.";
    }

    @Override
    public ArrayList<Coordenada> getAlcanceAtkProibido(int opcao) {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        Coordenada temp = new Coordenada();

        if (opcao == 1) {
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 2, coord.getColuna());
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha(), coord.getColuna() + 2);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 1);
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 2, coord.getColuna());
            proibidos.add(temp.clone());

            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 1);
            proibidos.add(temp.clone());
        } else {
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() - 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() - 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 1);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 2);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 2, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() - 1, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 1, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 2, coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna() + 4);
            proibidos.add(temp.clone());
        }
        return proibidos;
    }

}
