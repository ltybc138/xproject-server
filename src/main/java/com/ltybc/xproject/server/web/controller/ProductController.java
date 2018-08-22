package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import com.ltybc.xproject.server.service.CategoryService;
import com.ltybc.xproject.server.service.ProductService;
import com.ltybc.xproject.server.service.ex.CategoryNotFoundException;
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
        Product product = productService.getById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with id:" + id + " not found");
        }
        return product;
    }

    @GetMapping(path = "", params = "categoryId")
    public List<Product> getProductsByCategoryId(@RequestParam("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            throw new CategoryNotFoundException("Category with id=" + categoryId + " not found");
        }
        return productService.getProductsByCategory(category);
    }

    @GetMapping(path = "", params = "categoryTag")
    public List<Product> getProductsByTCategoryTag(@RequestParam("categoryTag") String categoryTag) {
        Category category = categoryService.getCategoryByTag(categoryTag);
        if (category == null) {
            throw new CategoryNotFoundException("Category with categoryTag=" + categoryTag + " not found");
        }
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
