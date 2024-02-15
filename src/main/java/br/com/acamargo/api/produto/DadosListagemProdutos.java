package br.com.acamargo.api.produto;

public record DadosListagemProdutos(long codigo, String nome, float preco) {

    public DadosListagemProdutos(Produto produto) {
        this(produto.getCodigo(), produto.getNome(), produto.getPreco());
    }
}
