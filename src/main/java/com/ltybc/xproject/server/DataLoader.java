package com.ltybc.xproject.server;

import com.ltybc.xproject.server.dao.UsersDao;
import com.ltybc.xproject.server.model.Role;
import com.ltybc.xproject.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private UsersDao usersDao;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        User user1 = new User("user", "user@gmail.com", "password", Role.USER_ROLE);
        User user2 = new User("admin", "admin@gmail.com", "password", Role.ADMIN_ROLE);
        User user3 = new User("ltybc", "ltybc@gmail.com", "password", Role.USER_ROLE);
        User user4 = new User("denis", "denis@gmail.com", "password", Role.USER_ROLE);

        usersDao.save(user1);
        usersDao.save(user2);
        usersDao.save(user3);
        usersDao.save(user4);
    }
}
