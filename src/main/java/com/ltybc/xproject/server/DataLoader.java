package com.ltybc.xproject.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltybc.xproject.server.dao.CategoryDao;
import com.ltybc.xproject.server.dao.ProductDao;
import com.ltybc.xproject.server.dao.UserDao;
import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import com.ltybc.xproject.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        setUpUsers();
        setUpCategories();
        setUpProducts();
    }

    private void setUpUsers() {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        List<User> users = null;
        try {
            users = mapper.readValue(new File(classLoader.getResource("init/users.json").getFile()),
                    new TypeReference<List<User>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
        userDao.save(users);
    }

    private void setUpCategories() {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        List<Category> categories = null;
        try {
            categories = mapper.readValue(new File(classLoader.getResource("init/categories.json").getFile()),
                    new TypeReference<List<Category>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        categoryDao.save(categories);
    }

    private void setUpProducts() {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        List<Product> products = null;
        try {
            products = mapper.readValue(new File(classLoader.getResource("init/products.json").getFile()),
                    new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        productDao.save(products);
    }
}
