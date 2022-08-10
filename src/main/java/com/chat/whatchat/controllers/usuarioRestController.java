package com.chat.whatchat.controllers;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.whatchat.model.usuario;
import com.chat.whatchat.repository.usuarioRepo;

@RestController
public class usuarioRestController {

    @PostMapping("/cadastro")
    public ResponseEntity<?> create(@ModelAttribute usuario usr) {

        usuarioRepo.getCurrentInstance().create(usr);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/logar")
    public ResponseEntity<Long> logarUsuario(@ModelAttribute usuario usra) {
        String email = usra.getEmail();
        String senha = usra.getSenha();
        usuario usr = usuarioRepo.getCurrentInstance().read(email, "email");
        // System.out.println(usr.getEmail());
        // System.out.println(usr.getSenha());
        System.out.println(email);
        System.out.println(senha);
        if ((!(usr == null)) && usr.getEmail().equals(email) && usr.getSenha().equals(senha)) {
            System.out.println("deu bom");
            return new ResponseEntity<Long>(usr.getId(),HttpStatus.OK);
        } else {
            System.out.println("deu bo");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/usuario/{id}")
    public usuario read(@PathVariable("id") long id) {
        return usuarioRepo.getCurrentInstance().read(id);
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<usuario>> readAll() {
        return new ResponseEntity<List<usuario>>(usuarioRepo.getCurrentInstance().readAll(), HttpStatus.OK);
    }
}
