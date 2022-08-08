package com.example.Whatchat.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "mensagens")
public class mensagem {
    
    public mensagem() {
    }

    public mensagem(LocalDateTime send, String mensagem, long idSender, long idReceiver) {
        this.send = send;
        this.mensagem = mensagem;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime send;

    @Column
    private String mensagem;

    @Column
    private long idSender;

    @Column
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
