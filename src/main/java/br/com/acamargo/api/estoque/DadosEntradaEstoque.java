package br.com.acamargo.api.estoque;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record DadosEntradaEstoque(
                                  @NotBlank
                                  long quantidade,
                                  @NotBlank
                                  @JsonFormat(pattern = "dd/MM/yyyy")
                                  Date dataEntradaProduto) {
}
