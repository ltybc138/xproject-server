package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.User;
import com.ltybc.xproject.server.service.UserService;
import com.ltybc.xproject.server.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("{login}")
    public User getUserByLogin(@PathVariable String login) {
        User user = userService.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException("User with login:\'" + login + "\' not found");
        }
        return user;
    }

    @PostMapping("")
    public void createNewUser(@RequestBody @Valid User user) {
        userService.save(user);
    }

    @PutMapping("")
    public void updateUser(@RequestBody @Valid User user) {
        String login = user.getLogin();
        if (userService.findByLogin(login) == null) {
            throw new UserNotFoundException("User with login:\'" + login + "\' not found");
        }
        userService.updateUser(user);
    }

    @DeleteMapping("{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        if (userService.findByLogin(login) == null) {
            throw new UserNotFoundException("User with login:\'" + login + "\' not found");
        }
        userService.deleteByLogin(login);
    }
}
