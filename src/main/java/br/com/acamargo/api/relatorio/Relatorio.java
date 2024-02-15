package br.com.acamargo.api.relatorio;

import br.com.acamargo.api.pedido.PedidoInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;


@Getter
@Setter
public class Relatorio {

    private String nome;
    private Long cpf;
    private Date dataNascimento;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private List<PedidoInfo> pedidos;


    public Relatorio(String nome, Long cpf, Date dataNascimento, String cep, String logradouro, String bairro, String localidade, String uf, List<PedidoInfo> pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.pedidos = pedidos;
    }

}
