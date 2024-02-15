package br.com.acamargo.api.controller;

import br.com.acamargo.api.cliente.Cliente;
import br.com.acamargo.api.cliente.ClienteRepository;
import br.com.acamargo.api.pedido.Pedido;
import br.com.acamargo.api.pedido.PedidoInfo;
import br.com.acamargo.api.pedido.PedidoRepository;
import br.com.acamargo.api.produto.Produto;
import br.com.acamargo.api.relatorio.Relatorio;
import br.com.acamargo.api.relatorio.RelatorioPorMes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Getter
@Setter
@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    public RelatorioController(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<RelatorioPorMes> gerarRelatorioPorMesEAno(@PathVariable int ano, @PathVariable int mes) {
        Date dataInicial = Date.from(LocalDate.of(ano, mes, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataFinal = Date.from(LocalDate.of(ano, mes, 1).with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());

        List<Pedido> pedidosDoMes = pedidoRepository.findByDataCompraBetween(dataInicial, dataFinal);

        Map<Produto, Integer> vendasPorProduto = new HashMap<>();
        Map<Produto, Map<Cliente, Integer>> detalhesVendasPorProduto = new HashMap<>();

        for (Pedido pedido : pedidosDoMes) {
            Produto produto = pedido.getProduto();
            Cliente cliente = pedido.getCliente();
            int quantidade = pedido.getQuantidade();

            // Verifique se tanto o produto quanto o cliente não são nulos
            if (produto != null && cliente != null) {
                vendasPorProduto.put(produto, vendasPorProduto.getOrDefault(produto, 0) + quantidade);

                // Atualizar detalhes de vendas por produto e cliente
                Map<Cliente, Integer> detalhesPorCliente = detalhesVendasPorProduto.getOrDefault(produto, new HashMap<>());
                detalhesPorCliente.put(cliente, detalhesPorCliente.getOrDefault(cliente, 0) + quantidade);
                detalhesVendasPorProduto.put(produto, detalhesPorCliente);
            }
        }

        return ResponseEntity.ok(new RelatorioPorMes(dataInicial, dataFinal, vendasPorProduto, detalhesVendasPorProduto));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Relatorio> gerarRelatorio(@PathVariable Long cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        String viaCepUrl = "https://viacep.com.br/ws/{cep}/json";
        RestTemplate restTemplate = new RestTemplate();
        EnderecoResponse enderecoResponse = restTemplate.getForObject(viaCepUrl, EnderecoResponse.class, cliente.getCep());

        List<Pedido> pedidos = pedidoRepository.findByCliente(cliente);

        List<PedidoInfo> pedidosInfo = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidosInfo.add(new PedidoInfo(
                    pedido.getProduto().getNome(),
                    pedido.getQuantidade(),
                    pedido.getDataCompra()
            ));
        }

        Relatorio relatorio = new Relatorio(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                cliente.getCep(),
                enderecoResponse.getLogradouro(),
                enderecoResponse.getBairro(),
                enderecoResponse.getLocalidade(),
                enderecoResponse.getUf(),
                pedidosInfo
        );

        return ResponseEntity.ok(relatorio);
    }

    @Getter
    @Setter
    private static class EnderecoResponse {
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
    }
}
