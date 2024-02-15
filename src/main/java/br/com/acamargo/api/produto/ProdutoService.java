package br.com.acamargo.api.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto getProductsById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
    }
}
