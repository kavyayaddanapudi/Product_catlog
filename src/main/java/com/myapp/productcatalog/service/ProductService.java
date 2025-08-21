package com.myapp.productcatalog.service;

import com.myapp.productcatalog.model.Product;

import com.myapp.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public Product createProduct(Product product) {
        
        if (product.getAttributeValues() != null) {
            product.getAttributeValues().forEach(value -> value.setProduct(product));
        }
        return productRepository.save(product);
    }

    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
