package com.example.Whatchat.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Whatchat.model.mensagem;
import com.example.Whatchat.repository.mensagemRepo;

@Service
public class mensagemService {

    @Autowired
    private mensagemRepo repo;

    public mensagemService() {
    }

    public void create(mensagem msg) {
        repo.save(msg);
    }

    public Iterator<mensagem> searchMensagem(String msg) {
        return repo.findBymensagem(msg);
    }

    public Iterator<mensagem> readChat(long idReceiver, long idSender) {
        return repo.findByIdReceiverAndIdSender(idReceiver, idSender);
    }

    public Iterator<mensagem> readReceivedMensagem(long idReceiver) {
        return repo.findByidReceiver(idReceiver);
    }
}


