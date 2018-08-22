package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.CategoryDao;
import com.ltybc.xproject.server.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findOne(id);
    }

    @Override
    public Category getCategoryByTag(String tag) {
        return categoryDao.getByTag(tag);
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }
}
