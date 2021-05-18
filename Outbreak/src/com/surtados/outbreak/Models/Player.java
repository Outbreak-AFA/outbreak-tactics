package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Player {
    private int id; // PK para relacionamento de 1:N com personagens
    private String nome;
    private String email;
    private String senha;
    private int vitorias;
    private int derrotas;
    public ArrayList<Item> conquistas = new ArrayList<>();
    public ArrayList<Personagem> time = new ArrayList<>();

    public Player(String nome, String email, String senha, int vitorias, int derrotas, ArrayList<Item> conquistasPlayer) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setVitorias(vitorias);
        setDerrotas(derrotas);
        conquistas.addAll(conquistasPlayer);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> receberItens(ArrayList<Item> itens) {
        return itens;
    }

    public Personagem getPersonagem() {
        System.out.println("Selecione um personagem de seu time:");
        for (int i=0; i<time.size(); i++) {
            System.out.println("[" + (i+1) + "] - " + time.get(i).getNome());
        }
        Scanner scan = new Scanner(System.in);
        int escolha = scan.nextInt();
        if (escolha < 1 || escolha > time.size()) {
            System.out.println("Opção inválida! Digite novamente.");
            return getPersonagem();
        }
        return time.get(escolha-1);
    }

    public void selecionarConquista() {
        Scanner scan = new Scanner(System.in);
        if (conquistas.size() > 0) {
            System.out.println("\nOpa! " + getNome() + ", pelo visto você possui conquistas! Deseja atribuir alguma delas a algum personagem de seu time? (S | N)");
        String escolha = scan.nextLine();
        if (escolha.toLowerCase().equals("s") || escolha.toLowerCase().equals("sim")) {
            System.out.println("Certo! Escolha qual item deseja implementar.");
            for (int i=0; i<conquistas.size(); i++) {
                System.out.println("[" + (i+1) + "] - " + conquistas.get(i).getNome());
            }
            int escolhaConq = scan.nextInt();
            if (escolhaConq < 1 || escolhaConq > conquistas.size()) {
                System.out.println("Opa! Opção inválida!");
                selecionarConquista();
                return;
            }
            Item itemEscolhido = conquistas.get(escolhaConq-1);
            System.out.println("Ok. Agora escolha qual personagem receber o privilégio de " +
                    itemEscolhido.getNome() + ": ");
            Personagem p = getPersonagem();
            System.out.println(p.equiparItem(itemEscolhido));
        }
        }
    }

    public void escolherPersonagens() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Personagem> personagens = new ArrayList<>();
        personagens.add(new Gosminha("Gosminha", getId(), this));
        personagens.add(new Gengah("Gengah", getId(), this));
        personagens.add(new Pyromancer("Pyromancer", getId(), this));
        personagens.add(new Arqueiro("Arqueiro", getId(), this));
        personagens.add(new Troll("Troll", getId(), this));
        personagens.add(new Guerreira("Alice", getId(), this));
        personagens.add(new Fadinha("Ophelia", getId(), this));
        personagens.add(new MrCanhao("Mr. Canhão", getId(), this));
        personagens.add(new LapaGod("Lapa", getId(), this));
        for (int i=0; i<Sistema.limitePersonagens; i++) {
            while (true) {
                System.out.println(getNome() + ", escolha o " + (i+1) + "º personagem:");
                System.out.println("[1] - Gosminha");
                System.out.println("[2] - Gengah");
                System.out.println("[3] - Pyromancer");
                System.out.println("[4] - Arqueiro");
                System.out.println("[5] - Troll");
                System.out.println("[6] - Guerreira");
                System.out.println("[7] - Fadinha");
                System.out.println("[8] - Mr. Canhão");
                int escolha = scan.nextInt();
                scan.nextLine();
                if (escolha > 0 && escolha <= 9) {
                    System.out.println(personagens.get(escolha-1).descricao());
                    System.out.println("Deseja adicionar " + personagens.get(escolha-1).getNome() + "" +
                            " ao seu time?");
                    String resposta = scan.nextLine();
                    if (resposta.toLowerCase().equals("s") || resposta.toLowerCase().equals("sim")) {
                        if (escolha == 1) {
                            time.add(new Gosminha("Gosminha", getId(), this));
                        } else if (escolha == 2) {
                            time.add(new Gengah("Gengah", getId(), this));
                        } else if (escolha == 3) {
                            time.add(new Pyromancer("Pyromancer", getId(), this));
                        } else if (escolha == 4) {
                            time.add(new Arqueiro("Arqueiro", getId(), this));
                        } else if (escolha == 5) {
                            time.add(new Troll("Troll", getId(), this));
                        } else if (escolha == 6) {
                            time.add(new Guerreira("Alice", getId(), this));
                        } else if (escolha == 7) {
                            time.add(new Fadinha("Ophelia", getId(), this));
                        } else if (escolha == 8) {
                            time.add(new MrCanhao("Mr. Canhão", getId(), this));
                        } else if (escolha == 9) {
                            time.add(new LapaGod("Lapa", getId(), this));
                        }
                        break;
                    }
                } else System.out.println(
                        "Opção inválida! Por favor, insira novamente!"
                );
            }
        }
    }

    public void mostrarTime() {
        System.out.println("\nTime de: " + getNome());
        for (Personagem p : time) {
            System.out.println(p.getNome());
        }
    }

    public boolean perdeu(Mapa mapa) {
        int mortes = 0;
        for (Personagem p : time) {
            if (p.morreu()) {
                System.out.println(p.getNome() + " morreu :(");
                mapa.removerPersonagem(p);
                time.remove(p);
            }
        }
        return mortes == time.size();
    }

    public void listarTime(Mapa mapa) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vez de " + getNome() + "================");
        System.out.println("Escolha um personagem do seu time para realizar suas ações:");
        for (Personagem p : time) {
            System.out.println("[" + (time.indexOf(p) + 1) + "] " + p.getNome());
        }
        System.out.println("==============================================");
        System.out.print(">>> ");
        int opcao = scan.nextInt();
        if (opcao > 0 && opcao <= time.size()) {
            time.get(opcao-1).mostrarStatus();
            time.get(opcao-1).menuOpcoes(mapa);
        } else {
            System.out.println("Opção inválida!");
            listarTime(mapa);
            return;
        }
        System.out.println("Turno encerrado!");
    }
}
