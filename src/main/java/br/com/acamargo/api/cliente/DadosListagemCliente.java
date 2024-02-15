package br.com.acamargo.api.cliente;

import br.com.acamargo.api.produto.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record DadosListagemCliente(String nome, @JsonFormat(pattern = "dd/MM/yyyy")Date dataNascimento, long cpf, String cep) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getDataNascimento(), cliente.getCpf(), cliente.getCep());
    }
}
