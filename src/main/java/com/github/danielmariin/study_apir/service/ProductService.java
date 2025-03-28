package com.github.danielmariin.study_apir.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.danielmariin.study_apir.dto.ProductRequestCreate;
import com.github.danielmariin.study_apir.dto.ProductRequestUpdate;
import com.github.danielmariin.study_apir.model.Product;
import com.github.danielmariin.study_apir.repository.ProductRepository;

@Service
public class ProductService {
   
    @Autowired
    private ProductRepository productRepository;
    private static final BigDecimal VALOR_PADRAO = new BigDecimal(200);

    public Product createProduct(ProductRequestCreate dto) {
        
        Product product = new Product();
        product.setNome(dto.getNome());
        product.setValor(VALOR_PADRAO);
        
        return productRepository.save(product);
    }
    public Optional<Product> getProductById(Long id) {
        // return products.stream()
         //     .filter(p -> p.getId().equals(id))
         //     .findFirst();
         return null;
    }
    public List<Product> getAll() {
        return null;
    }

    public Optional<Product> updateProduct(Long id, ProductRequestUpdate dto) {
    
        // return products.stream()
         //     .filter(p -> p.getId().equals(id))
         //     .findFirst()
         //     .map(p -> {                
         //         p.setValor(dto.getValor());
         //         return p;
         //         }
         //     );

        return null;
    }
    public boolean deleteProduct(Long id) {
            // return products.removeIf(p -> p.getId().equals(id));
         return false;
        
    }
    

}
