package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
