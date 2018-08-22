package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getById(Long id);
    List<Product> getProductsByCategory(Category category);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(Long id);
}
