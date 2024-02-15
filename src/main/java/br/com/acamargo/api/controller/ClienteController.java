package br.com.acamargo.api.controller;

import br.com.acamargo.api.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<DadosListagemCliente> listar() {
        return repository.findAll().stream().map(DadosListagemCliente::new).toList();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteComEndereco> clienteComEndereco(@PathVariable Long cpf) {
        Cliente cliente = repository.findByCpf(cpf);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        String viaCepUrl = "https://viacep.com.br/ws/{cep}/json";
        RestTemplate restTemplate = new RestTemplate();
        try {
            EnderecoResponse enderecoResponse = restTemplate.getForObject(viaCepUrl, EnderecoResponse.class, cliente.getCep());

            ClienteComEndereco clienteComEndereco = new ClienteComEndereco(
                    cliente.getNome(),
                    cliente.getDataNascimento(),
                    cliente.getCpf(),
                    cliente.getCep(),
                    enderecoResponse.getLogradouro(),
                    enderecoResponse.getBairro(),
                    enderecoResponse.getLocalidade(),
                    enderecoResponse.getUf()
            );

            return ResponseEntity.ok(clienteComEndereco);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    private static class EnderecoResponse {
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getLocalidade() {
            return localidade;
        }

        public void setLocalidade(String localidade) {
            this.localidade = localidade;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }
    }
}