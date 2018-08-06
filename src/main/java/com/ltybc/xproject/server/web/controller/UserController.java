package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.User;
import com.ltybc.xproject.server.service.UserService;
import com.ltybc.xproject.server.service.ex.InvalidUserDataException;
import com.ltybc.xproject.server.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("{login}")
    public User getUserByLogin(@PathVariable String login) {
        User user = userService.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException("User with login=\'" + login + "\' not found");
        }
        return user;
    }

    @PostMapping("")
    public void createNewUser(@RequestBody User user) {
        if (user.getLogin() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new InvalidUserDataException("Input data is invalid");
        }
        userService.save(user);
    }

    @PutMapping("")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        userService.deleteByLogin(login);
    }
}
