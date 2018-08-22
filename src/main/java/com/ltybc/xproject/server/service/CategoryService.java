package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void addCategory(Category category);
}
