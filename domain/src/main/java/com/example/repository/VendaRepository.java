package com.example.repository;


import com.example.entity.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface VendaRepository extends MongoRepository<Venda, String> {
    List<Venda> findByClienteId(String clienteId);
}