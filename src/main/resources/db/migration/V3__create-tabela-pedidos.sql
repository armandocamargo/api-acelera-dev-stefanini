CREATE TABLE pedidos
(
    id integer NOT NULL auto_increment,
    cliente_id bigint,
    produto_id integer,
    quantidade integer,
    data_compra DATE,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cpf),
    FOREIGN KEY (produto_id) REFERENCES Produtos(codigo),
    PRIMARY KEY (id)

);