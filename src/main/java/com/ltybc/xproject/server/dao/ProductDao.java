package com.ltybc.xproject.server.dao;

import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends CrudRepository<Product, Long> {
    void deleteProductById(Long id);

    Product getById(Long id);

    List<Product> getAllByCategory(Category category);
}
