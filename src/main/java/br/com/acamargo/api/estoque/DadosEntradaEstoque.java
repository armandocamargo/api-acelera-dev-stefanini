package br.com.acamargo.api.estoque;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEntradaEstoque(
                                  @NotBlank
                                  long quantidade,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{10}")
                                  String dataEntradaProduto) {
}
