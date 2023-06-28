package com.example.demo.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService  = productService;
    }

    @GetMapping("/products")
    @CrossOrigin
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    @CrossOrigin
    public void createProduct(@RequestBody Product newProduct) {
        productService.addNewProduct(newProduct);
    }

}
