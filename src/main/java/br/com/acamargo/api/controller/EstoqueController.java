package br.com.acamargo.api.controller;

import br.com.acamargo.api.estoque.DadosEntradaEstoque;
import br.com.acamargo.api.estoque.Estoque;
import br.com.acamargo.api.estoque.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository repository;
    @PostMapping("{id}")
    public ResponseEntity<String> registrarEntradaEstoque(@PathVariable Long id, @RequestBody DadosEntradaEstoque dados) {
        repository.save(new Estoque(id, dados));
        return ResponseEntity.ok("Entrada de estoque registrada com sucesso para o produto de ID " + id);
    }
}
