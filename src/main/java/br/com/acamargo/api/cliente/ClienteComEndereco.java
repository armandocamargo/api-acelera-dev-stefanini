package br.com.acamargo.api.cliente;
public record ClienteComEndereco(
        String nome,
        String dataNascimento,
        long cpf,
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}