package com.example.repository.adapter;

import com.example.entity.Produto;
import com.example.repository.orm.ProdutoOrmMongo;

public class ProdutoRepositoryAdapter {
    private ProdutoRepositoryAdapter() {}

    public static Produto castOrm(ProdutoOrmMongo orm) {
        return new Produto(orm.id(), orm.nome(), orm.preco());
    }

    public static ProdutoOrmMongo castEntity(Produto entity) {
        return new ProdutoOrmMongo(entity.id(), entity.nome(), entity.preco());
    }
}