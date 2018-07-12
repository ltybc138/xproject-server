package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.User;
import com.ltybc.xproject.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserService database;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return database.findAll();
    }

    @GetMapping("/users/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return database.findByLogin(login);
    }

    @PostMapping("/users")
    public void createNewUser(@RequestBody User user) {
        database.save(user);
    }

    @DeleteMapping("/users/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        database.deleteByLogin(login);
    }
}
