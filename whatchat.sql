CREATE DATABASE IF NOT EXISTS whatchat;
use whatchat;

create table if not exists usuarios (
	ID bigint auto_increment,
	nome varchar(255),
    email varchar(255) unique,
    senha varchar(255),
    usertag varchar(255) unique,
    primary key (ID)
);

CREATE TABLE IF NOT EXISTS usuarioContato
(
  donoID bigInt,
  contatoID bigInt,
  PRIMARY KEY(donoID, contatoID),
  FOREIGN KEY(donoID) REFERENCES Usuarios(ID),
  FOREIGN KEY(contatoID) REFERENCES Usuarios(ID)
);

create table mensagens(
	ID bigint  auto_increment,
	send timestamp,
    mensagem varchar(255),
    idSender bigint,
    idReceiver bigint,
    primary key(ID)
);
select * from mensagens where idSender = 1 and idReceiver = 2 or idSender = 2 and idReceiver = 1 order by send ASC;
select * from usuarioContato;
select * from mensagens;
select * from usuarios;