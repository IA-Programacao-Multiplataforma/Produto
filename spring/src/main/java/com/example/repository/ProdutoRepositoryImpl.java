package com.example.repository;

import com.example.entity.Produto;
import com.example.repository.adapter.ProdutoRepositoryAdapter;
import com.example.repository.mongo.ProdutoRepositoryWithMongoDB;
import com.example.repository.orm.ProdutoOrmMongo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {
    private final ProdutoRepositoryWithMongoDB mongoRepo;

    public ProdutoRepositoryImpl(ProdutoRepositoryWithMongoDB mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoOrmMongo orm = ProdutoRepositoryAdapter.castEntity(produto);
        ProdutoOrmMongo salvo = mongoRepo.save(orm);
        return ProdutoRepositoryAdapter.castOrm(salvo);
    }

    @Override
    public List<Produto> buscarTodos() {
        return mongoRepo.findAll().stream()
                .map(ProdutoRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarPorId(String id) {
        return mongoRepo.findById(id).map(ProdutoRepositoryAdapter::castOrm);
    }

    @Override
    public void deletar(String id) {
        mongoRepo.deleteById(id);
    }
}