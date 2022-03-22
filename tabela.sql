create database fofuxos_pet;
use fofuxos_pet;
create table fofuxos_pet (
id_cadastro int primary key,
nome varchar (500) not null,
endereco varchar (500) not null,
bairro varchar (300) not null,
telefone varchar (20) not null,
nome_pet varchar (100) not null,
raca varchar (100) not null,
observacao varchar (500), 
pagamento varchar (15) not null,
pacote varchar (10) not null,
rn_sim varchar (15) not null
);
