package br.com.acamargo.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record DadosEntradaDeProdutos(@NotBlank
                                     Long id,
                                     @NotBlank
                                     long quantidade,
                                     @NotBlank
                                     Date dataEntradaProduto
                                    ) {
}
