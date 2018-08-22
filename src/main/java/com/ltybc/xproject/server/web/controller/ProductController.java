package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import com.ltybc.xproject.server.service.CategoryService;
import com.ltybc.xproject.server.service.ProductService;
import com.ltybc.xproject.server.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping(path = "", params = "categoryId")
    public List<Product> getProductsByCategoryId(@RequestParam("categoryId") Long categoryId) {
        // TODO check if category id exists
        Category category = categoryService.getCategoryById(categoryId);
        return productService.getProductsByCategory(category);
    }

    @PostMapping("")
    public void createProduct(@RequestBody @Valid Product product) {
        productService.addProduct(product);
    }

    @PutMapping("")
    public void updateProduct(@RequestBody @Valid Product product) {
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
