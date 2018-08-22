package com.ltybc.xproject.server.dao;

import com.ltybc.xproject.server.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Long> {
    Category getByTag(String tag);
}
