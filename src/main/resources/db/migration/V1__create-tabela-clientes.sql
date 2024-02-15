CREATE TABLE clientes
(
    id integer NOT NULL auto_increment,
    nome varchar(50),
    cpf bigint,
    data_nascimento varchar(10),
    cep varchar(15),
    PRIMARY KEY (id),
    UNIQUE(cpf)
);