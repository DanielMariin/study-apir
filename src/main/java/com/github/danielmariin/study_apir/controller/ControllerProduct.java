package com.github.danielmariin.study_apir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.danielmariin.study_apir.model.Product;
import com.github.danielmariin.study_apir.service.ProductService;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {

        //System.out.println(product.getNome());

        Product productCreated = productService.createProduct(product);

        return ResponseEntity.status(201).body(productCreated);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
                        @PathVariable Long id, 
                        @RequestBody Product product) {   
        Product productUpdate = 
        productService.updateProduct(id, product);

        return ResponseEntity.status(200).body(productUpdate);
    }
    @GetMapping
    public ResponseEntity<String> find() {

        productService.getProductById(null);
        return ResponseEntity.status(200).body("Pêra");
    }
    @DeleteMapping
    public ResponseEntity<Void> delete() {

        productService.deleteProduct(null);
        return ResponseEntity.status(204).build();
    }
}
