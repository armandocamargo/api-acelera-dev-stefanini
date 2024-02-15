package br.com.acamargo.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public static Endereco buscarEnderecoPorCep(String cep) {
        final String viaCepUrl = "https://viacep.com.br/ws/{cep}/json";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(viaCepUrl, Endereco.class, cep);
    }
}