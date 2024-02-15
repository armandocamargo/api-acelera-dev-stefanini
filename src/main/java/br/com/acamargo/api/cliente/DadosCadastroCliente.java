package br.com.acamargo.api.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank
        Long cpf,
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{10}")
        String dataNascimento,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String cep
    ) {
}
