package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "vendas")
public class Venda {
    @Id
    private String id;
    private String clienteId;
    private List<ItemVenda> itens;
    private Integer totalItens;

    public void calcularTotal() {
        if (this.itens != null) {
            this.totalItens = this.itens.stream()
                    .mapToInt(ItemVenda::getQuantidade)
                    .sum();
        } else {
            this.totalItens = 0;
        }
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public List<ItemVenda> getItens() { return itens; }
    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
        calcularTotal();
    }

    public Integer getTotalItens() { return totalItens; }
    public void setTotalItens(Integer totalItens) { this.totalItens = totalItens; }
}