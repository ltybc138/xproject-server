package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.ProductDao;
import com.ltybc.xproject.server.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        // TODO check if product already exist
        productDao.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productDao.deleteProductById(id);
    }
}