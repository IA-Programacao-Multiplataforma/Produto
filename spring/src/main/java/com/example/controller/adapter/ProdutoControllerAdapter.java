package com.example.controller.adapter;

import com.example.controller.dto.request.ProdutoRequest;
import com.example.entity.Produto;
import java.util.UUID;

public class ProdutoControllerAdapter {
    private ProdutoControllerAdapter() {}

    public static Produto castPostRequest(ProdutoRequest request) {
        return new Produto(
                UUID.randomUUID().toString(),
                request.nome(),
                request.preco()
        );
    }
}