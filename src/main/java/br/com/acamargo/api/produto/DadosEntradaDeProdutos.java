package br.com.acamargo.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEntradaDeProdutos(@NotBlank
                                     Long id,
                                     @NotBlank
                                     long quantidade,
                                     @NotBlank
                                     @Pattern(regexp = "\\d{7}")
                                     String dataEntradaProduto
                                    ) {
}
