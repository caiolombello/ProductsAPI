package com.products.apirest.resources;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Products")
public class ProductResource {

    @Autowired
     ProductRepository productRepository;

    @ApiOperation(value = "Returns a list of products.")
    @GetMapping("/products")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @ApiOperation(value = "Return a unique product.")
    @GetMapping("/product/{id}")
    public Product product(@PathVariable(value="id") long id) {
        return productRepository.findById(id);
    }

    @ApiOperation(value = "Save a product.")
    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @ApiOperation(value = "Delete a product.")
    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }

    @ApiOperation(value = "Update a product.")
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

}
