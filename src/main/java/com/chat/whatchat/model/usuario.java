package com.chat.whatchat.model;

import java.util.List;

public class usuario {
    
    public usuario() {
    }

    private long id;

    private String nome;


    private String email;

    private String senha;

    private String usertag;

    private List<usuario> Contatos;

    public usuario(String nome, String email, String senha, String usertag) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usertag = usertag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUsertag() {
        return usertag;
    }

    public void setUsertag(String usertag) {
        this.usertag = usertag;
    }

    public List<usuario> getContatos() {
        return Contatos;
    }

    public void setContatos(List<usuario> contatos) {
        Contatos = contatos;
    }
}
