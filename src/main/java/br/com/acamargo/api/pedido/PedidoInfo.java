package br.com.acamargo.api.pedido;

import java.util.Date;

public class PedidoInfo {

    private String nomeProduto;
    private int quantidade;
    private Date dataCompra;

    public PedidoInfo(String nomeProduto, int quantidade, Date dataCompra) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.dataCompra = dataCompra;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
}