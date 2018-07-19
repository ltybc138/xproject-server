package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.UsersDao;
import com.ltybc.xproject.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<User> findAll() {
        return (List<User>) usersDao.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return usersDao.findByLogin(login);
    }

    @Override
    public void save(User user) {
        usersDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        usersDao.save(user);
    }

    @Override
    public void deleteByLogin(String login) {
        usersDao.deleteByLogin(login);
    }
}
