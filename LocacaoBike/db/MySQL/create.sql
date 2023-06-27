create database LocacaoBike;

use LocacaoBike;

CREATE TABLE CLIENTE (CPF varchar(11) PRIMARY KEY, sexo varchar(256) NOT NULL, email varchar(256) NOT NULL, nome varchar(256) NOT NULL, senha varchar(256), telefone varchar(256) NOT NULL, data_nascimento date NOT NULL);

CREATE TABLE LOCADORA (CNPJ varchar(14) PRIMARY KEY, cidade varchar(256) NOT NULL, email varchar(256) NOT NULL, nome varchar(256) NOT NULL, senha varchar(256));

CREATE TABLE LOCACAO (CPF varchar(11), CNPJ varchar(14), data_locacao datetime NOT NULL, FOREIGN KEY (CPF) REFERENCES CLIENTE(CPF), FOREIGN KEY (CNPJ) REFERENCES LOCADORA(CNPJ));

INSERT INTO LOCADORA (CNPJ,cidade,email,nome,senha)
VALUES
  ('81816304803883',"Açailândia","dui.quis@outlook.com","Montes Nascetur Corporation","UAU98GXH1QG"),
  ('53582506660484',"Osasco","nostra.per.inceptos@protonmail.net","Luctus Ut LLC","GWM17NPY2NA"),
  ('68710705096438',"Barra do Corda","purus@google.edu","Arcu Et Corporation","BKK21XGG1BA");
