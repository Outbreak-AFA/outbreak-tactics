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

    public void salvarDados() {
        JSONObject players = Sistema.getUsuarios();
        JSONArray usuarios = players.getJSONArray("usuarios");

        for (int i=0; i<usuarios.length(); i++) {
            JSONObject objTemp = (JSONObject) usuarios.get(i);
            if (objTemp.get("email").equals(getEmail())) {
                JSONObject playerJson = new JSONObject();
                playerJson.put("nome", getNome());
                playerJson.put("email", getEmail());
                playerJson.put("senha", getSenha());
                playerJson.put("vitorias", getVitorias());
                playerJson.put("derrotas", getDerrotas());

                JSONArray conqJson = new JSONArray();
                for (int j=0; j< this.conquistas.size(); j++) {
                    conqJson.put(conquistas.get(j).getTipoDeItem());
                }
                playerJson.put("conquistas", conqJson);
                usuarios.put(i, playerJson);
                players.put("usuarios", usuarios);
            }
        }
        String json = players.toString();

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

    public void selecionarConquista() {

    }

    public void escolherPersonagens() {
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<Sistema.limitePersonagens; i++) {
            while (true) {
                System.out.println(getNome() + ", escolha o " + i+1 + "º personagem:");
                System.out.println("[1] - Gosminha");
                System.out.println("[2] - Gengah");
                System.out.println("[3] - Pyromancer");
                System.out.println("[4] - Arqueiro");
                System.out.println("[5] - Troll");
                System.out.println("[6] - Guerreira");
                System.out.println("[7] - Fadinha");
                System.out.println("[8] - Mr. Canhão");

                int escolha = scan.nextInt();
            }
        }
    }
}
