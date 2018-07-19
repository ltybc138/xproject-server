package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<User> findAll();
    User findByLogin(String login);
    void save(User user);
    void updateUser(User user);
    void deleteByLogin(String login);
}
