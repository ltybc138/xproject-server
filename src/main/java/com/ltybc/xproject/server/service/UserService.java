package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.UserDao;
import com.ltybc.xproject.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void deleteByLogin(String login) {
        userDao.removeByLogin(login);
    }
}
