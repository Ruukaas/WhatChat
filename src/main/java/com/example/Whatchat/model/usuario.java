package com.example.Whatchat.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class usuario {
    
    public usuario() {
    }

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;

    @Column(unique = true)
    private String usertag;

    @ElementCollection
    private List<String> Contatos;

    public usuario(String name, String email, String senha, String usertag) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
