package com.surtados.outbreak.Core;

import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.Utils.Dados;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static boolean acertou(Personagem p) {
        int valor = Dados.random(20, p.getAgl() * (-1));
        if (valor >= 5) return  true;
        return false;
    }

    public static ArrayList<Coordenada> getAlcance(Personagem personagem, Mapa mapa) {
        boolean possivel;
        int agl = personagem.getAgl();
        ArrayList<Coordenada> coordPadrao = new ArrayList<>();
        Coordenada personagemCoord = personagem.coord;
        Coordenada tempCoord = new Coordenada();
        ArrayList<Coordenada> possiveisCoordenadas = new ArrayList<>();

        // criando alcance padrão 3x3
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (i != 0 && j != 0) {
                    tempCoord.setPosicao(personagemCoord.getLinha() + i,
                            personagemCoord.getColuna() + j);
                    coordPadrao.add(tempCoord.clone());
                }
            }
        }

        if (agl >= 4) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() , personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha(), personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());
        }
        if (agl >= 6) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 3, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() , personagemCoord.getColuna() - 3);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha(), personagemCoord.getColuna() + 3);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 3, personagemCoord.getColuna());
            coordPadrao.add(tempCoord.clone());
        }
        if (agl >= 8) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2 , personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());
        }
        if (agl >= 10) {
            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() - 1);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 2, personagemCoord.getColuna() + 1);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 1, personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() - 1, personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 1, personagemCoord.getColuna() - 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 1 , personagemCoord.getColuna() + 2);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna() - 1);
            coordPadrao.add(tempCoord.clone());

            tempCoord.setPosicao(personagemCoord.getLinha() + 2, personagemCoord.getColuna() + 1);
            coordPadrao.add(tempCoord.clone());
        }
        // verificando obstáculos
        for (Coordenada cp : coordPadrao) {
            possivel = true;
            for (Obstaculo ob : mapa.obstaculos) {
                if (cp.getLinha() == ob.coord.getLinha() && (cp.getColuna() == ob.coord.getColuna())) {
                    possivel = false;
                }
            }
            if (possivel) possiveisCoordenadas.add(cp);
        }
        return possiveisCoordenadas;
    }

    public static void instrucoes() {
        System.out.println("Regras do Jogo:\n" +
                "1-Ao iniciar o jogo será solicitado o login ou o cadastro do usuário;\n" +
                "2-Em seguida, o player poderá configura o mapa com a largura e altura desejada;\n" +
                "3-O jogador deverá escolher o modo de jogo de sua preferência;\n" +
                "4-Surgirá o inventario de cada usuário, afim do mesmo selecionar, caso queira, os itens \"recebidos\" nas partidas anteriores;\n" +
                "5-O player1 fará a seleção de personagens, logo em seguida, o player2;\n" +
                "6-O jogador deverá selecionar o personagem que terá acesso ao item pré-selecionado do inventario;\n" +
                "7-O jogo é iniciado, com os personagens já posicionado;\n" +
                "8-Haverá o sorteio para qual dos players jogará primeiro;\n" +
                "9-Á cada turno 1 \"avatar\" poderá ser escolhido pelo player para fazer suas ações(mover, atacar e/ou usar item. Depois dessa ação o turno é encerrado;\n" +
                "10-Existem dois tipos de itens, consumiveis, são utilizados somente 1 vez, sumindo do inventario logo em seguida. Já os usaveis, são elementos que podem ser usados até o final da partida;\n" +
                "11-Os consumiveis são possuem a probabilidade de aparecer aleatoriamente, e os usaveis podendo ser obtidos caso, ao morrer, um de seus oponentes deixe cair, porém para \n" +
                "que o outro personagem possa pegar esse item é necessário ele ficar em cima do local que o item caiu.Caso o item seja do tipo usável esse item será registrado na conta \n" +
                "do jogador para ser utilizado em outras batalhas;\n" +
                "12-Ao decorrer do jogo, os personagens vão acumulando pontos de surto, e quanto essa pontuação chega no limite, o personagem libera opção de surtar;\n" +
                "13- Ganha quem estiver com personagens ainda no jogo;\n" +
                "14- Após jogo ser encerrado terá uma opção de encerrar jogo ou iniciar uma nova partida, caso queira encerrar serão levados para tela inicial, caso queiram uma nova\n" +
                " serão levados para o item 4.");
    }

    public static void creditos() {
        System.out.println("Disciplina: Linguagem de Programação I");
        System.out.println("Desenvolvedores:");
        System.out.println("Amanda Rigaud");
        System.out.println("Antônio Cesar");
        System.out.println("Felipe Ribeiro");
        System.out.println("Docente: Marcos Lapa (Obrigado por tudo!)");
    }

    public static boolean menuJogo() {
        System.out.println("======= OUTBREACK TACTICS ======");
        System.out.println("================================");
        System.out.println("[1] - Iniciar jogo");
        System.out.println("[2] - Instruções");
        System.out.println("[3] - Créditos");
        System.out.println("[4] - Sair");
        System.out.println("================================");

        Scanner scan = new Scanner(System.in);
        final int opcao = scan.nextInt();


        switch (opcao) {
            case 1:
                return true;
            case 2:
                instrucoes();
                break;
            case 3:
                creditos();
                break;
            case 4:
                return false;
            default:
                System.out.println("Comando inválido!");
        }
        System.out.println();
        return menuJogo();
    }

    public static JSONObject getUsuarios() {
        String json = "";
        try {
            Scanner scan = new Scanner(new File("Outbreak/src/usuarios.json"));
            while (scan.hasNext()) {
                json = json.concat(scan.nextLine());
            }
            scan.close();
            JSONObject obj = new JSONObject(json);
            return obj;
        } catch (FileNotFoundException exception) {
            File novoArq = new File("Outbreak/src/usuarios.json");
            try {
                novoArq.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject objVazio = new JSONObject();
            JSONArray arrayVazio = new JSONArray();
            objVazio.put("usuarios", arrayVazio);
            return objVazio;
        }
    }

    public static void registrar(String nome, String email, String senha) {
        JSONObject objeto = new JSONObject();
        JSONArray conquistasArray = new JSONArray();
        JSONObject usuarios = getUsuarios();
        JSONArray usuariosArray = usuarios.getJSONArray("usuarios");
        objeto.put("nome", nome);
        objeto.put("email", email);
        objeto.put("senha", senha);
        objeto.put("vitorias", 0);
        objeto.put("derrotas", 0);

        objeto.put("conquistas", conquistasArray);

        usuariosArray.put(objeto);
        usuarios.put("usuarios", usuariosArray);

        String json = usuarios.toString();

        try {
            FileWriter escritor = new FileWriter(new File("Outbreak/src/usuarios.json"));
            BufferedWriter bw = new BufferedWriter(escritor);
            bw.write(json);
            bw.close();
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player login(String email, String senha) {
        JSONObject usuarios = getUsuarios();
        JSONArray usuariosArray = usuarios.getJSONArray("usuarios");

        for (int i=0; i<usuariosArray.length(); i++) {
            JSONObject objTemp = (JSONObject) usuariosArray.get(i);
            if (objTemp.get("email").equals(email) && (objTemp.get("senha").equals(senha))) {
                System.out.println(objTemp.get("email"));
                ArrayList<Item> conq = new ArrayList<>();
                JSONArray conqJson = objTemp.getJSONArray("conquistas");
                for (int j=0; j< conqJson.length(); j++) {
                    conq.add(new Item(conqJson.get(i).toString()));
                }
                return new Player(
                        objTemp.get("nome").toString(),
                        objTemp.get("email").toString(),
                        objTemp.get("senha").toString(),
                        (int) objTemp.get("vitorias"),
                        (int) objTemp.get("derrotas"),
                        conq
                );
            }
        }
        return null;
    }
}
