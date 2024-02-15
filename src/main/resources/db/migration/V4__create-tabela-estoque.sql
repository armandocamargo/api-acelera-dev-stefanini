CREATE TABLE estoque (
        id integer NOT NULL auto_increment,
        produto_id INT,
        quantidade INT,
        data_entrada_produto varchar(10),
        FOREIGN KEY (produto_id) REFERENCES Produtos(codigo),
        PRIMARY KEY (id)
);