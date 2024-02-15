CREATE TABLE produtos
(
    id integer NOT NULL auto_increment,
    codigo integer,
    nome varchar(50),
    preco float,
    PRIMARY KEY (id),
    UNIQUE (codigo)
);