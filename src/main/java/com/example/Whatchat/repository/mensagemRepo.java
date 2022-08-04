package com.example.Whatchat.repository;

import java.util.Iterator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Whatchat.model.mensagem;

@Repository
public interface mensagemRepo extends JpaRepository<mensagem, Long> {

    Iterator<mensagem> findBymensagem(String mensagem);
    Iterator<mensagem> findByidReceiver(long idReceiver);
    Iterator<mensagem> findByidSender(long idSender);
    Iterator<mensagem> findByIdReceiverAndIdSender(long idReceiver, long idSender);
}
