package br.com.acamargo.api.cliente;

import br.com.acamargo.api.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ClienteComEndereco {
        private String nome;
        private Date dataNascimento;
        private Long cpf;
        private String cep;
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
        private List<Pedido> pedidos; // Novo campo

        public ClienteComEndereco(String nome, @JsonFormat(pattern = "dd/MM/yyyy") Date dataNascimento, Long cpf, String cep, String logradouro, String bairro, String localidade, String uf, List<Pedido> pedidos) {
                this.nome = nome;
                this.dataNascimento = dataNascimento;
                this.cpf = cpf;
                this.cep = cep;
                this.logradouro = logradouro;
                this.bairro = bairro;
                this.localidade = localidade;
                this.uf = uf;
                this.pedidos = pedidos;
        }

}