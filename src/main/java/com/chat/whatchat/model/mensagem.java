package com.chat.whatchat.model;

import java.time.LocalDateTime;
public class mensagem {
    
    public mensagem() {
    }

    public mensagem(String mensagem, long idSender, long idReceiver) {
        this.mensagem = mensagem;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
    }


    private long id;

    private LocalDateTime send;

    private String mensagem;

    private long idSender;

    private long idReceiver;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getSend() {
        return send;
    }

    public void setSend(LocalDateTime send) {
        this.send = send;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(long idReceiver) {
        this.idReceiver = idReceiver;
    }
}
