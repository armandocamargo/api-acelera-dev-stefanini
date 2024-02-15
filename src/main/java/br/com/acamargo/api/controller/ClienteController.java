package br.com.acamargo.api.controller;

import br.com.acamargo.api.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<DadosListagemCliente> listar() {
        return repository.findAll().stream().map(DadosListagemCliente::new).toList();
    }

}