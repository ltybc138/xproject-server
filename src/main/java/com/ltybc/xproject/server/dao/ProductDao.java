package com.ltybc.xproject.server.dao;

import com.ltybc.xproject.server.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
    void deleteProductById(Long id);
    Product getById(Long id);
}
