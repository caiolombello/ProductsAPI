package com.products.apirest.resources;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product product(@PathVariable(value="id") long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

}
