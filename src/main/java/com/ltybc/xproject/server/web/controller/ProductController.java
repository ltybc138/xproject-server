package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Product;
import com.ltybc.xproject.server.service.ProductService;
import com.ltybc.xproject.server.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        if (productService.getById(id) == null) {
            throw new ProductNotFoundException("Product with id:" + id + " not found");
        }
        return productService.getById(id);
    }

    @PostMapping("")
    public void createProduct(@RequestBody Product product) {
        // TODO throw an exception if product object is incorrect(validate fields)
        productService.addProduct(product);
    }

    @PutMapping("")
    public void updateProduct(@RequestBody Product product) {
        long id = product.getId();
        if (productService.getById(id) == null) {
            throw new ProductNotFoundException("Product with id:" + id + " not found");
        }
        productService.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        if (productService.getById(id) == null) {
            throw new ProductNotFoundException("Product with id:" + id + " not found");
        }
        productService.deleteProductById(id);
    }
}
