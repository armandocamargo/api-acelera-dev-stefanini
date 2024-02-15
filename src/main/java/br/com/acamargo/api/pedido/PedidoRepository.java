package br.com.acamargo.api.pedido;

import br.com.acamargo.api.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByDataCompraBetween(Date dataInicial, Date dataFinal);
}