package com.surtados.outbreak.Core;

import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.Utils.Dados;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    public static int limitePersonagens;

    public static boolean acertou(Personagem p) {
        int valor = Dados.random(20, p.getAgl() * (-1));
        if (valor >= 5) return  true;
        return false;
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
        System.out.println("\n\nVersão: 0.1");
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

    public static boolean registrar(String nome, String email, String senha) {
        JSONObject objeto = new JSONObject();
        JSONArray conquistasArray = new JSONArray();
        JSONObject usuarios = getUsuarios();
        JSONArray usuariosArray = usuarios.getJSONArray("usuarios");
        for (int i=0; i<usuariosArray.length(); i++) {
            JSONObject objTemp = (JSONObject) usuariosArray.get(i);
            if (objTemp.get("email").equals(email)) {
                return false;
            }
        }
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
        return true;
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
                    conq.add(new Item(conqJson.get(j).toString()));
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

    public static Player registroOuLogin(int index) {
        Scanner scan = new Scanner(System.in);
        String nome, email, senha;

        System.out.println("======= OUTBREACK TACTICS ======");
        System.out.println("================================");
        System.out.println("Jogador " + (index + 1) + ":");
        System.out.println("[1] - Realizar Login de usuário");
        System.out.println("[2] - Registrar novo usuário");
        System.out.println("================================");

        final int escolha = scan.nextInt();
        scan.nextLine();

        switch (escolha) {
            case 1:
                System.out.println("Certo! Vamos efetuar o login!");
                System.out.print("Por favor, digite o e-mail registrado\n>>> ");
                email = scan.nextLine();
                System.out.print("Por favor, digite sua senha\n>>> ");
                senha = scan.nextLine();
                Player p1 = login(email, senha);
                if (p1 == null) {
                    System.out.println("Login não efetuado :(");
                    System.out.println("E-mail ou senha incorretos!");
                    return registroOuLogin(index);
                }
                System.out.println("Seja bem vinde, " + p1.getNome() + "!\n Tenha um bom jogo!");
                return p1;
            case 2:
                System.out.println("Certo! Vamos efetuar o cadastro!");
                System.out.print("Primeiro digite um nickname!\n>>> ");
                nome = scan.nextLine();
                System.out.print("Por favor, digite um e-mail\n>>> ");
                email = scan.nextLine();
                System.out.print("Por favor, digite uma senha\n>>> ");
                senha = scan.nextLine();

                boolean reg = registrar(nome, email, senha);
                if (!reg) {
                    System.out.println("E-mail já cadastrado! Por favor, utilize outro.");
                    return registroOuLogin(index);
                }
                System.out.println("Você será redirecionado para a tela de login!");
                return registroOuLogin(index);
            default:
                System.out.println("opção inválida!");
                return registroOuLogin(index);
        }

    }

    public static Mapa configMapa() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor insira a largura do mapa (min: 10 / max: 60): ");
        int largura = scan.nextInt();
        System.out.println("Por favor insira a altura do mapa (min: 10 / max: 60): ");
        int altura = scan.nextInt();

        return new Mapa(altura, largura);
    }

    public static void modoDeJogo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Por favor, insira a quantidade de personagens por jogador. (min: 2 / max: 8)\n>>> ");

        limitePersonagens = scan.nextInt();
        if (limitePersonagens >= 2 && limitePersonagens <= 8) {
            System.out.println("Certo! Cada jogador terá de escolher " + limitePersonagens + " personagens!");
        } else {
            System.out.println("Quantidade informada não permitida!");
            modoDeJogo();
        }
    }

    public static void sortearPlayers(ArrayList<Player> players) {
        int rdn = Dados.random();
        if (rdn % 2 == 0) {
            System.out.println("Dados: " + rdn);
            System.out.println("Jogador 1: " + players.get(0).getNome());
            System.out.println("Jogador 2: " + players.get(1).getNome());
            return;
        }
        ArrayList<Player> temp = new ArrayList<>();
        temp.add(players.get(1));
        temp.add(players.get(0));

        players.clear();
        players.addAll(temp);
        System.out.println("Dados: " + rdn);
        System.out.println("Jogador 1: " + players.get(0).getNome());
        System.out.println("Jogador 2: " + players.get(1).getNome());
    }

    public static void adicionarConquista(Item item, Player p) {
        JSONObject usuarios = getUsuarios();
        JSONArray usuariosArray = usuarios.getJSONArray("usuarios");
        for (int i=0; i<usuariosArray.length(); i++) {
            JSONObject objTemp = (JSONObject) usuariosArray.get(i);
            if (objTemp.get("email").equals(p.getEmail())) {
                ArrayList<String> conq = new ArrayList<>();
                JSONArray conqJson = objTemp.getJSONArray("conquistas");
                for (int j=0; j< conqJson.length(); j++) {
                    conq.add(conqJson.get(j).toString());
                }
                conq.add(item.getTipoDeItem());
                objTemp.put("conquistas", conq);
                usuariosArray.put(i, objTemp);
            }
        }
        usuarios.put("usuarios", usuariosArray);
        try {
            FileWriter escritor = new FileWriter("Outbreak/src/usuarios.json");
            BufferedWriter bw = new BufferedWriter(escritor);
            bw.write(usuarios.toString());
            bw.close();
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}