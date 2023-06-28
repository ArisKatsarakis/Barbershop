package com.example.demo.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository  = productRepository;
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product newProduct) {
        productRepository.save(newProduct);
    }
}
