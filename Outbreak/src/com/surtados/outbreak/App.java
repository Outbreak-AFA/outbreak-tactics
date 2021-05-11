package com.surtados.outbreak;

import com.surtados.outbreak.Models.Gengah;
import com.surtados.outbreak.Models.Mapa;
import com.surtados.outbreak.Models.Personagem;
import com.surtados.outbreak.Models.Pyromancer;
import com.surtados.outbreak.Utils.Dados;

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
        Gengah g1 = new Gengah("Dark");

        Mapa mapa= new Mapa(20, 60);

        mapa.personagens.add(g1);
        mapa.personagens.add(p1);

        g1.mover(2, 2, mapa);
        p1.mover(5, 8, mapa);
        mapa.plotarMatriz();
    }

}
