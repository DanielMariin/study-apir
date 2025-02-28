package com.github.danielmariin.study_apir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.danielmariin.study_apir.service.ProductService;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {

    @Autowired
    private ProductService productService = new ProductService();

    @PostMapping
    public ResponseEntity<String> create() {

        productService.createProduct(null);

        return ResponseEntity.status(201).body("Produto cadastrado");
    }
    @PutMapping
    public ResponseEntity<String> update() {

        productService.updateProduct(null, null);
        return ResponseEntity.status(200).body("Produto atualizado");
    }
    @GetMapping
    public ResponseEntity<String> find() {

        productService.getProductById(null);
        return ResponseEntity.status(200).body("maça");
    }
    @DeleteMapping
    public ResponseEntity<Void> delete() {

        productService.deleteProduct(null);
        return ResponseEntity.status(204).build();
    }
}
