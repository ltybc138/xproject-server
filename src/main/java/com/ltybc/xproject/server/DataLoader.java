package com.ltybc.xproject.server;

import com.ltybc.xproject.server.dao.UsersDao;
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
        User user = new User(1l, "user", "user@gmail.com", "password");
        usersDao.save(user);
    }
}
