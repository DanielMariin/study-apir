package com.github.danielmariin.dto;

import java.math.BigDecimal;

import com.github.danielmariin.study_apir.model.Product;

public class ProductResponse {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public ProductResponse toDto (Product product) {
        this.setId(product.getId());
        this.setNome(product.getNome());
        this.setValor(product.getValor());
        
        return this;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    }
