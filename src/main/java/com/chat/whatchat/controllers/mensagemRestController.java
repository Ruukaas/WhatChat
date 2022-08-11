package com.chat.whatchat.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.chat.whatchat.model.mensagem;
import com.chat.whatchat.repository.mensagemRepo;

@RestController
public class mensagemRestController {

    @PostMapping("/mensagem")
    public ResponseEntity<?> create(@ModelAttribute mensagem msg) {

        try {
            mensagemRepo.getCurrentInstance().create(msg);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/mensagem/{idSender}/{idReceiver}")
    public ResponseEntity<List<mensagem>> read(@PathVariable("idSender") long idSender, @PathVariable("idReceiver") long idReceiver) {
        try {
            return new ResponseEntity<List<mensagem>>(mensagemRepo.getCurrentInstance().readChat(idSender, idReceiver), HttpStatus.OK);
        } catch(SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
