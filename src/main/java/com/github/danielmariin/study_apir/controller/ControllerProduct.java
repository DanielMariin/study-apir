package com.github.danielmariin.study_apir.controller;

import java.util.List;
import java.util.Optional;

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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {      
        boolean result = productService.deleteProduct(id);
        if (result) {
            return ResponseEntity.noContent().build();
            
        } else {
            return ResponseEntity.notFound().build();
        }

        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
                        @PathVariable Long id, 
                        @RequestBody Product product) {   
        
        
    return productService.updateProduct(id, product)
    .map(ResponseEntity ::ok)
    .orElse(ResponseEntity.notFound().build());
                    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        
        return ResponseEntity.status(200).body(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        return ResponseEntity.ok(productService.getAll());
    }
}
