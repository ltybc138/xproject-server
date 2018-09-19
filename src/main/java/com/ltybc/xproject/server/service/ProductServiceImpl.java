package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.ProductDao;
import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productDao.getAllByCategory(category);
    }

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productDao.deleteProductById(id);
    }
}
