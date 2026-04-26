package com.example.entity;


public class ItemVenda {
    private String produtoNome;
    private Integer quantidade;

    public ItemVenda() {}

    public ItemVenda(String produtoNome, Integer quantidade) {
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
    }

    public String getProdutoNome() { return produtoNome; }
    public void setProdutoNome(String produtoNome) { this.produtoNome = produtoNome; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}