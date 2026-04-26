package com.example.controller;

import com.example.entity.Venda;
import com.example.repository.VendaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos/vendas")
public class VendaController {

    private final VendaRepository repository;

    public VendaController(VendaRepository repository) {
        this.repository = repository;
    }

    // Criar compra (Autenticado via Gateway)
    @PostMapping
    public Venda criarVenda(@RequestBody Venda venda) {
        venda.calcularTotal();
        return repository.save(venda);
    }

    // Listar todas as compras (Autenticado via Gateway)
    @GetMapping
    public List<Venda> listarTodas() {
        return repository.findAll();
    }

    // Compras por cliente (Autenticado via Gateway)
    @GetMapping("/cliente/{clienteId}")
    public List<Venda> listarPorCliente(@PathVariable String clienteId) {
        return repository.findByClienteId(clienteId);
    }
}