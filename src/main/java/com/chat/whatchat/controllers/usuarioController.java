package com.chat.whatchat.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class usuarioController {

    @RequestMapping("/")
    public String telaInicial() {
        return "login/login.html";
    }

    @RequestMapping("/logado")
    public String telaWhatChat() {
        return "chat/chat.html";
    }

    @RequestMapping("/cadastro")
    public String telaCadastro() {
        return "cadastro/cadastro.html";
    }

    @RequestMapping("/whatchat")
    public String WhatChat() {
        return "home/home.html";
    }

    @RequestMapping("/chat")
    public String telaChat() {
        return "chat/chat.html";
    }
    
}
