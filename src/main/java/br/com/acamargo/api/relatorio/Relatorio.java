package br.com.acamargo.api.relatorio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "relatorio")
@Entity(name = "relatorio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Relatorio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long produtoId;
    private long quantidade;
    private String dataEntradaProduto;
}
