package com.example.Whatchat.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Whatchat.model.usuario;
import com.example.Whatchat.repository.usuarioRepo;

public class usuarioService {

    @Autowired
    private usuarioRepo repo;

    public usuarioService() {

    }



    public void create(usuario usr) {
        repo.save(usr);
    }

    public void read() {

    }

}
