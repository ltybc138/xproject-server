package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.User;
import com.ltybc.xproject.server.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public void deleteByLogin(String login) {
        usersRepository.deleteByLogin(login);
    }
}
