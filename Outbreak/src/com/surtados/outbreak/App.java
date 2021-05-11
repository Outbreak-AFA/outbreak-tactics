package com.surtados.outbreak;

import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.Utils.Dados;
import com.surtados.outbreak.Utils.Sistema;

import java.util.ArrayList;

public class App {

//    public static void main(String[] args) {
//        Pyromancer p1 = new Pyromancer("Dante");
//        Gengah g1 = new Gengah("Dark");
//
//        ArrayList<Personagem> lista = new ArrayList<>();
//        lista.add(p1); lista.add(g1);
//
//        p1.mostrarStatus();
//        g1.mostrarStatus();
//        while (!p1.morreu() && !g1.morreu()) {
//            if (Dados.random() % 2 == 0) {
//                lista.get(0).atacarNatural(lista.get(1));
//            } else lista.get(0).habilidadeEspecial(lista.get(1));
//            App.trocarTurno(lista);
//        }
//        p1.mostrarStatus();
//        g1.mostrarStatus();
//    }
//
//    public static void trocarTurno(ArrayList<Personagem> list) {
//        ArrayList<Personagem> temp = new ArrayList<>();
//        temp.add(list.get(1));
//        temp.add(list.get(0));
//        list.clear();
//        list.addAll(temp);
//    }

    public static void main(String[] args) {
        Pyromancer p1 = new Pyromancer("Dante");
        Gengah g = new Gengah("Dark");
        Mapa mapa = new Mapa(10, 30);

        Obstaculo pedra = new Obstaculo('#');

        g.coord.setPosicao(5, 10);
        pedra.coord.setPosicao(6, 10);

        mapa.inserirPersonagem(g);
        mapa.inserirObsetaculo(pedra);
        mapa.plotarMatriz();

        for (Coordenada c : Sistema.getAlcance(g, mapa)) {
            System.out.println(c.getLinha() + " " + c.getColuna());
        }

    }

}
