package br.com.acamargo.api.cliente;

import br.com.acamargo.api.produto.Produto;

public record DadosListagemCliente(String nome, String dataNascimento, long cpf, String cep) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getDataNascimento(), cliente.getCpf(), cliente.getCep());
    }
}
