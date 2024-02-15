package br.com.acamargo.api.controller;

import br.com.acamargo.api.cliente.Cliente;
import br.com.acamargo.api.cliente.ClienteRepository;
import br.com.acamargo.api.pedido.Pedido;
import br.com.acamargo.api.pedido.PedidoRepository;
import br.com.acamargo.api.produto.Produto;
import br.com.acamargo.api.produto.ProdutoRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping("/xlsx")
    public ResponseEntity<String> handleXlsxUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("O arquivo está vazio");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() == 0) {
                    continue;
                }

                Cell cellCodigoProduto = row.getCell(0);
                Cell cellCpfUsuario = row.getCell(1);
                Cell cellQuantidadeProdutos = row.getCell(2);
                Cell cellDataCompra = row.getCell(3);

                if (cellCodigoProduto != null && cellCpfUsuario != null && cellQuantidadeProdutos != null && cellDataCompra != null) {
                    int codigoProduto = (int) cellCodigoProduto.getNumericCellValue();
                    long cpfUsuario = (long) cellCpfUsuario.getNumericCellValue();
                    int quantidadeProdutos = (int) cellQuantidadeProdutos.getNumericCellValue();
                    Date dataCompra = cellDataCompra.getDateCellValue();

                    Cliente cliente = clienteRepository.findByCpf(cpfUsuario);
                    if (cliente == null) {
                        return ResponseEntity.badRequest().body("Cliente com CPF " + cpfUsuario + " não encontrado.");
                    }

                    Produto produto = produtoRepository.findByCodigo(codigoProduto);
                    if (produto == null) {
                        return ResponseEntity.badRequest().body("Produto com código " + codigoProduto + " não encontrado."); // Alteração aqui
                    }

                    Pedido pedido = new Pedido();
                    pedido.setCliente(cliente);
                    pedido.setProduto(produto);
                    pedido.setQuantidade(quantidadeProdutos);
                    pedido.setDataCompra(dataCompra);

                    pedidoRepository.save(pedido);
                } else {
                    return ResponseEntity.ok("Upload bem-sucedido. Os dados foram salvos no banco de dados.");
                }
            }

            return ResponseEntity.ok("Upload bem-sucedido. Os dados foram salvos no banco de dados.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
