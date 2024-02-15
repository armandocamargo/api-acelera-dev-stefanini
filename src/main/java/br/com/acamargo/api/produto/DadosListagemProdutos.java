package br.com.acamargo.api.produto;

public record DadosListagemProdutos(int codigo, String nome, float preco) {

    public DadosListagemProdutos(Produto produto) {
        this(produto.getCodigo(), produto.getNome(), produto.getPreco());
    }
}
