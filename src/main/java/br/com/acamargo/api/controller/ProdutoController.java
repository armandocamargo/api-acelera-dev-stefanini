package br.com.acamargo.api.controller;

import br.com.acamargo.api.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<DadosListagemProdutos> listar() {

        return repository.findAll().stream().map(DadosListagemProdutos::new).toList();
    }
    @GetMapping("{id}")
    public ResponseEntity<Produto> create(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getProductsById(id));
    }

}
