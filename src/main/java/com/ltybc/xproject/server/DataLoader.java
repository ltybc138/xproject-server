package com.ltybc.xproject.server;

import com.ltybc.xproject.server.dao.CategoryDao;
import com.ltybc.xproject.server.dao.ProductDao;
import com.ltybc.xproject.server.dao.UserDao;
import com.ltybc.xproject.server.model.Category;
import com.ltybc.xproject.server.model.Product;
import com.ltybc.xproject.server.model.Role;
import com.ltybc.xproject.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        setUpCategories();
        setUpUsers();
        setUpProducts();
    }

    private void setUpCategories() {
        Category category1 = new Category("TV");
        Category category2 = new Category("Computers");
        Category category3 = new Category("Food");
        Category category4 = new Category("Drinks");
        Category category5 = new Category("Books");
        Category category6 = new Category("Shows");

        categoryDao.save(category1);
        categoryDao.save(category2);
        categoryDao.save(category3);
        categoryDao.save(category4);
        categoryDao.save(category5);
        categoryDao.save(category6);
    }

    private void setUpUsers() {

        User user1 = new User("user1", "user@gmail.com", "password", Role.USER);
        User user2 = new User("admin", "admin@gmail.com", "password", Role.ADMIN);
        User user3 = new User("ltybc", "ltybc@gmail.com", "password", Role.USER);
        User user4 = new User("denis", "denis@gmail.com", "password", Role.USER);
        User user5 = new User("notch", "notch@gmail.com", "password", Role.USER);

        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        userDao.save(user4);
        userDao.save(user5);
    }

    private void setUpProducts() {
        Product product1 = new Product("Apple MacBook Pro 13\'", 1299.0, "https://www.re-store.ru/upload/resize_cache/iblock/7d6/1120_770_17f5c944b3b71591cc9304fac25365de2/7d67229c35ddcfd8df81984fd6985c1f.jpg");
        Product product2 = new Product("Starbucks coffee", 29.95, "https://fiu-assets-2-syitaetz61hl2sa.stackpathdns.com/static/use-media-items/47/46137/full-800x900/5847f74f/pike_place_wb_fy14_us_GR.jpeg?resolution=0");

        productDao.save(product1);
        productDao.save(product2);
    }

}
