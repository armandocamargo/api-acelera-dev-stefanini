CREATE TABLE clientes
(
    id integer NOT NULL auto_increment,
    nome varchar(50),
    cpf bigint,
    data_nascimento DATE,
    cep varchar(15),
    PRIMARY KEY (id),
    UNIQUE(cpf)
);