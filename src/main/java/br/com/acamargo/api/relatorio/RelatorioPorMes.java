package br.com.acamargo.api.relatorio;

import br.com.acamargo.api.cliente.Cliente;
import br.com.acamargo.api.pedido.PedidoInfo;
import br.com.acamargo.api.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class RelatorioPorMes {

    @JsonIgnore
    private Date dataInicial;

    @JsonIgnore
    private Date dataFinal;

    private Map<Produto, Integer> vendasPorProduto;
    private Map<Produto, Map<Cliente, Integer>> detalhesVendasPorProduto;

    public RelatorioPorMes(Date dataInicial, Date dataFinal, Map<Produto, Integer> vendasPorProduto, Map<Produto, Map<Cliente, Integer>> detalhesVendasPorProduto) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.vendasPorProduto = vendasPorProduto;
        this.detalhesVendasPorProduto = detalhesVendasPorProduto;
    }

    public String getDataInicialFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataInicial);
    }

    public String getDataFinalFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataFinal);
    }
}
