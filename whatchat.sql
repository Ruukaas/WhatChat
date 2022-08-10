CREATE DATABASE IF NOT EXISTS Whatchat;

USE Whatchat;

CREATE TABLE IF NOT EXISTS Usuarios
(
  Identificador int auto_increment,
  Nome varchar(50),
  Email varchar(50),
  Usertag varchar(25),
  Senha varchar(25),
  PRIMARY KEY(Identificador)
);

CREATE TABLE IF NOT EXISTS UsuarioContato
(
  IdentificadorUsuario1 int,
  IdentificadorUsuario2 int,
  PRIMARY KEY(IdentificadorUsuario1, IdentificadorUsuario2),
  FOREIGN KEY(IdentificadorUsuario1) REFERENCES Usuarios(Identificador),
  FOREIGN KEY(IdentificadorUsuario2) REFERENCES Usuarios(Identificador)
);

CREATE TABLE IF NOT EXISTS Mensagens
(
  Identificador int auto_increment,
  UsuarioAutorId int,
  UsuarioReceptorId int,
  MensagemHorario datetime,
  MensagemConteudo varchar(250),
  PRIMARY KEY (Identificador),
  FOREIGN KEY (UsuarioAutorId) REFERENCES Usuarios(Identificador),
  FOREIGN KEY (UsuarioReceptorId) REFERENCES Usuarios(Identificador)
);
