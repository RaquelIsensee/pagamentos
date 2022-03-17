# pagamentos
Atividade 3 semestre ADS
create database pagamento;
use pagamento;  

create table funcionario( id int not null primary key auto_increment, nome varchar(40) not null, valor_hora float not null, cpf varchar(11) not null, rg varchar(7) not null, data_nascimento date not null, status_func boolean not null, genero character not null );  

create table salario_mensal( id int not null primary key auto_increment, mes date not null, valor float not null, id_funcionario int not null, foreign key id_funcionario(id_funcionario) references funcionario(id) );
