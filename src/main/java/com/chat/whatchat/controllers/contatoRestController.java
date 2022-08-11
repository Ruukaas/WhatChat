package com.chat.whatchat.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.whatchat.model.usuario;
import com.chat.whatchat.repository.contatosRepo;

@RestController
public class contatoRestController {
    
    @PostMapping("/contato/{idDono}/{idContato}")
    public ResponseEntity<?> create(@PathVariable("idDono") long idDono, @PathVariable("idContato") long idContato) {
        try {
            System.out.println("criar contato");
            contatosRepo.getCurrentInstance().create(idDono, idContato);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(SQLException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contato/{idDono}")
    public ResponseEntity<?> read(@PathVariable("idDono") long idDono) {
        try {
            return new ResponseEntity<List<usuario>>(contatosRepo.getCurrentInstance().readContatos(idDono), HttpStatus.OK);
        }catch(SQLException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
