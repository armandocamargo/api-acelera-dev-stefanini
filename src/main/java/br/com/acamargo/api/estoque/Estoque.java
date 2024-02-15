package br.com.acamargo.api.estoque;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "estoque")
@Entity(name = "estoque")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long produtoId;
    private long quantidade;
    private Date dataEntradaProduto;

    public Estoque(Long id, DadosEntradaEstoque dados) {
        this.produtoId = id;
        this.quantidade = dados.quantidade();
        this.dataEntradaProduto = dados.dataEntradaProduto();
    }
}

