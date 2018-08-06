package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.CartDao;
import com.ltybc.xproject.server.dao.UserDao;
import com.ltybc.xproject.server.model.Cart;
import com.ltybc.xproject.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;

    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteByLogin(String login) {
        Cart cart = userDao.findByLogin(login).getCart();
        userDao.deleteByLogin(login);
        cartDao.deleteById(cart.getId());
    }
}
