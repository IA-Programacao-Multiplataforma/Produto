package com.example.controller;


import com.example.controller.adapter.ProdutoControllerAdapter;
import com.example.controller.dto.request.ProdutoRequest;
import com.example.entity.Produto;
import com.example.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Produto criar(@RequestBody ProdutoRequest request) {
        Produto produto = ProdutoControllerAdapter.castPostRequest(request);
        return repository.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.buscarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable String id) {
        return repository.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        repository.deletar(id);
    }
}