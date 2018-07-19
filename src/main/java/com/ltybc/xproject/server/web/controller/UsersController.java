package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.User;
import com.ltybc.xproject.server.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return usersService.findAll();
    }

    @GetMapping("/users/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return usersService.findByLogin(login);
    }

    @PostMapping("/users")
    public void createNewUser(@RequestBody User user) {
        usersService.save(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        usersService.updateUser(user);
    }

    @DeleteMapping("/users/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        usersService.deleteByLogin(login);
    }
}
