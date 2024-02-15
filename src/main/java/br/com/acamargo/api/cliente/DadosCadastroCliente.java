package br.com.acamargo.api.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record DadosCadastroCliente(
        @NotBlank
        long cpf,
        @NotBlank
        String nome,
        @NotBlank
        @JsonFormat(pattern = "dd/MM/yyyy")
        Date dataNascimento,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String cep
    ) {
}
