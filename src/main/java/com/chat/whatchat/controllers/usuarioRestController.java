package com.chat.whatchat.controllers;

import java.sql.SQLException;
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

        try {
            usuarioRepo.getCurrentInstance().create(usr);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/logar")
    public ResponseEntity<Long> logarUsuario(@ModelAttribute usuario usra) {
        try {

            String email = usra.getEmail();
            String senha = usra.getSenha();
            usuario usr = usuarioRepo.getCurrentInstance().read(email, "email");
            // System.out.println(usr.getEmail());
            // System.out.println(usr.getSenha());
            System.out.println(email);
            System.out.println(senha);
            if ((!(usr == null)) && usr.getEmail().equals(email) && usr.getSenha().equals(senha)) {
                System.out.println("deu bom");
                return new ResponseEntity<Long>(usr.getId(), HttpStatus.OK);
            } else {
                System.out.println("deu bo");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> read(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<usuario> (usuarioRepo.getCurrentInstance().read(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{field}/{column}")
    public ResponseEntity<?> read(@PathVariable("field") String field, @PathVariable("column") String column) {
        try {
            System.out.println("Entrou");
            return new ResponseEntity<usuario>(usuarioRepo.getCurrentInstance().read(field, column), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    


    @GetMapping("/usuario")
    public ResponseEntity<List<usuario>> readAll() {
        try {
            return new ResponseEntity<List<usuario>>(usuarioRepo.getCurrentInstance().readAll(), HttpStatus.OK);
        }catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
