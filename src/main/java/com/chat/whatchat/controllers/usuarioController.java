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
        return "login/teste.html";
    }

    @RequestMapping("/cadastro")
    public String telaCadastro() {
        return "login/cadastro.html";
    }

    @RequestMapping("/esquecerSenha")
    public String telaEsqueceuSenha() {
        return "login/esquecerSenha.html";
    }

}
