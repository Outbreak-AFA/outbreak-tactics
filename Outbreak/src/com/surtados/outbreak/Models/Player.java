package com.surtados.outbreak.Models;

import java.util.ArrayList;

public class Player {
    private String nome;
    private String email;
    private String senha;
    private final ArrayList<Personagem> personagens = new ArrayList<>();

    public Player(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
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

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }
}
