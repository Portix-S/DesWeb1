create database LocacaoBike;

use LocacaoBike;

CREATE TABLE USUARIO(nome varchar(256), email varchar(256) PRIMARY KEY, senha varchar(256), papel varchar(256));

CREATE TABLE CLIENTE (CPF varchar(11) PRIMARY KEY, sexo varchar(256) NOT NULL, email varchar(256) NOT NULL, nome varchar(256) NOT NULL, senha varchar(256) NOT NULL, telefone varchar(256) NOT NULL, data_nascimento varchar(11) NOT NULL, papel varchar(256) NOT NULL);

CREATE TABLE LOCADORA (CNPJ varchar(14) PRIMARY KEY, cidade varchar(256) NOT NULL, email varchar(256) NOT NULL, nome varchar(256) NOT NULL, senha varchar(256) NOT NULL, papel varchar(256) NOT NULL);

CREATE TABLE LOCACAO (id BIGINT NOT NULL auto_increment PRIMARY KEY, CPF varchar(11), CNPJ varchar(14), data_locacao varchar(256) NOT NULL, hora_locacao varchar(256) NOT NULL);

INSERT INTO USUARIO (nome, email, senha, papel)
VALUES
  ("admin", "admin", "admin", "admin"),
  ("admin", "dui.quis@outlook.com", "admin", "admin"),
  ("admin", "nostra.per.inceptos@protonmail.net", "admin", "admin"),
  ("admin", "purus@google.edu", "admin", "admin"),
  ("admin", "at.egestas.a@protonmail.edu", "admin", "admin"),
  ("admin", "enim@icloud.edu", "admin", "admin"),
  ("admin", "magnis.dis@outlook.com", "admin", "admin"),
  ("admin", "nulla@yahoo.couk", "admin", "admin"),
  ("admin", "duis@outlook.org", "admin", "admin"),
  ("admin", "venenatis@protonmail.ca", "admin", "admin"),
  ("admin", "suspendisse@icloud.org", "admin", "admin"),
  ("admin", "varius.orci@aol.edu", "admin", "admin"),
  ("admin", "augue.eu.tellus@aol.ca", "admin", "admin"),
  ("admin", "morbi@google.org", "admin", "admin"),
  ("admin", "aliquam@icloud.org", "admin", "admin"),
  ("admin", "etiam.vestibulum.massa@aol.couk", "admin", "admin"),
  ("admin", "tempor@hotmail.org", "admin", "admin"),
  ("admin", "fusce.feugiat@hotmail.net", "admin", "admin"),
  ("admin", "nunc@hotmail.ca", "admin", "admin"),
  ("admin", "ornare.lectus.justo@yahoo.org", "admin", "admin"),
  ("admin", "mauris.sapien@icloud.com", "admin", "admin"),
  ("admin", "luctus@icloud.net", "admin", "admin"),
  ("admin", "aliquet.phasellus.fermentum@yahoo.ca", "admin", "admin"),
  ("admin", "id.ante@hotmail.ca", "admin", "admin");

INSERT INTO LOCADORA (CNPJ,cidade,email,nome,senha,papel)
VALUES
  ('81816304803883',"Açailândia","dui.quis@outlook.com","Montes Nascetur Corporation","UAU98GXH1QG","locadora"),
  ('53582506660484',"Osasco","nostra.per.inceptos@protonmail.net","Luctus Ut LLC","GWM17NPY2NA","locadora"),
  ('68710705096438',"Barra do Corda","purus@google.edu","Arcu Et Corporation","BKK21XGG1BA","locadora"),
  ('11111111111111', "São Carlos", "locadora1", "Locadora Teste 1", "locadora1", "locadora"),
  ('22222222222222', "São Carlos", "locadora2", "Locadora Teste 2", "locadora2", "locadora");

INSERT INTO CLIENTE (CPF, sexo, email, nome, senha, telefone, data_nascimento, papel)
VALUES
  ('11656417042',"Masculino","at.egestas.a@protonmail.edu","Felix Mota","VLX85QQV7LG","(84)608476104","1995-07-13","cliente"),
  ('11409211567',"Masculino","enim@icloud.edu","Lysandra Leite","DDI95ELN4OR","(16)424555162","2017-03-02","cliente"),
  ('12092370773',"Masculino","magnis.dis@outlook.com","Grant Santos","FGJ21FYD3CQ","(66)733280551","2002-04-23","cliente"),
  ('12019403009',"Feminino","nulla@yahoo.couk","Signe Garcia","VTC78MXQ3QN","(76)086216783","2004-05-25","cliente"),
  ('11184244404',"Feminino","duis@outlook.org","Ocean Brandao","HJK90VMQ3DR","(53)664977165","2018-03-11","cliente"),
  ('11135998452',"Masculino","venenatis@protonmail.ca","Channing Brandao","OJV35ODN1KI","(76)368123243","2020-08-14","cliente"),
  ('11193578164',"Masculino","suspendisse@icloud.org","Driscoll Ferraz","TCD13FOE5NF","(26)384227148","2015-05-07","cliente"),
  ('11855363127',"Masculino","varius.orci@aol.edu","Amber Galdino","MUV73NUW2RE","(97)411125778","1990-06-18","cliente"),
  ('11171396330',"Masculino","augue.eu.tellus@aol.ca","Dai Cavalcante","KCW23JRU6UX","(51)825474353","1998-09-07","cliente"),
  ('12167818293',"Masculino","morbi@google.org","Uriel Braga","HSK81KVN6MS","(71)436038651","2013-02-02","cliente");
INSERT INTO CLIENTE (CPF, sexo, email, nome, senha, telefone, data_nascimento, papel)
VALUES
  ('11932068947',"Feminino","aliquam@icloud.org","Gareth Nascimento","NJH36LNL8XH","(03)655220530","1991-03-18","cliente"),
  ('11949635508',"Feminino","etiam.vestibulum.massa@aol.couk","Fay de Castro","TVW63PLO2CV","(02)852763681","2017-12-23","cliente"),
  ('11550294198',"Feminino","tempor@hotmail.org","Jesse de Almeida","ZCY60BEO7MQ","(20)273218014","1992-08-09","cliente"),
  ('12069289195',"Masculino","fusce.feugiat@hotmail.net","Lyle de Oliveira","XDV18JRQ3PF","(71)180297356","1998-10-01","cliente"),
  ('11885459411',"Masculino","nunc@hotmail.ca","Rosalyn Diniz","XUC39TFS8KF","(80)063614833","2021-08-03","cliente"),
  ('11289805965',"Masculino","ornare.lectus.justo@yahoo.org","Shannon de Almeida","UBE51SEG5XR","(00)978718740","1992-02-20","cliente"),
  ('11386853112',"Masculino","mauris.sapien@icloud.com","Zorita da Cruz","FNJ52HKI8FV","(52)142665245","2005-02-12","cliente"),
  ('11235452985',"Feminino","luctus@icloud.net","Fitzgerald Siqueira","VTF66XXN4AK","(71)742851169","1999-03-19","cliente"),
  ('11416299908',"Masculino","aliquet.phasellus.fermentum@yahoo.ca","Candace Fonseca","DEH24SQI0VL","(83)832591868","1997-04-10","cliente"),
  ('12163487767',"Masculino","id.ante@hotmail.ca","Dana Coelho","GYP95XJM1BJ","(65)138039439","2008-07-07","cliente"),
  ('33333333333', "Masculino", "cliente1", "Cliente Teste 1", "cliente1", "16999999999", "01/01/1999", "cliente"),
  ('44444444444', "Masculino", "cliente2", "Cliente Teste 2", "cliente2", "16888888888", "01/01/1995", "cliente");

