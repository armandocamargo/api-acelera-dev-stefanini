package br.com.acamargo.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente getClientesByCpf(long cpf) {
        return repository.findByCpf(cpf);
    }
}
