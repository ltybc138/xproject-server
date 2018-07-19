package com.ltybc.xproject.server;

import com.ltybc.xproject.server.dao.ProductDao;
import com.ltybc.xproject.server.dao.UserDao;
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
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        setUpUsers();
        setUpProducts();
    }

    private void setUpUsers() {
        User user1 = new User("user", "user@gmail.com", "password", Role.USER_ROLE);
        User user2 = new User("admin", "admin@gmail.com", "password", Role.ADMIN_ROLE);
        User user3 = new User("ltybc", "ltybc@gmail.com", "password", Role.USER_ROLE);
        User user4 = new User("denis", "denis@gmail.com", "password", Role.USER_ROLE);

        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        userDao.save(user4);
    }

    private void setUpProducts() {
        Product product1 = new Product("Apple MacBook Pro 13\'", 1299.0, "https://www.re-store.ru/upload/resize_cache/iblock/7d6/1120_770_17f5c944b3b71591cc9304fac25365de2/7d67229c35ddcfd8df81984fd6985c1f.jpg");
        Product product2 = new Product("Starbucks coffee", 29.95, "https://fiu-assets-2-syitaetz61hl2sa.stackpathdns.com/static/use-media-items/47/46137/full-800x900/5847f74f/pike_place_wb_fy14_us_GR.jpeg?resolution=0");

        productDao.save(product1);
        productDao.save(product2);
    }

}
