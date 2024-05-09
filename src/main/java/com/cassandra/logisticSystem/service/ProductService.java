package com.cassandra.logisticSystem.service;

import com.cassandra.logisticSystem.data.model.Product;
import com.cassandra.logisticSystem.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method to retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to retrieve a product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // Method to create or update a product
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    // Method to delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

