package com.github.danielmariin.study_apir.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import com.github.danielmariin.study_apir.dto.ProductRequestCreate;
import com.github.danielmariin.study_apir.dto.ProductRequestUpdate;
import com.github.danielmariin.study_apir.dto.ProductResponse;
import com.github.danielmariin.study_apir.service.ProductService;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequestCreate dto) {

      
        return ResponseEntity.status(201).body(
                new ProductResponse().toDto(
                    productService.createProduct(dto)));
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
    public ResponseEntity<ProductResponse> 
                    update(@PathVariable Long id, @RequestBody ProductRequestUpdate dto) {   
        
        
    return productService.updateProduct(id, dto)
    .map(p -> new ProductResponse().toDto(p)) 
    .map(ResponseEntity :: ok)
    .orElse(ResponseEntity.notFound().build());                    
}

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        
        return productService.getProductById(id)
        .map(p -> new ProductResponse().toDto(p))
        .map(ResponseEntity :: ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> response =
        productService.getAll().stream()
            .map(p -> new ProductResponse().toDto(p))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
