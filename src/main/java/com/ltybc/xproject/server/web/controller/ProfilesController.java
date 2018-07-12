package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Profile;
import com.ltybc.xproject.server.service.ProfileServiceHardcodedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilesController {
    @Autowired
    private ProfileServiceHardcodedImpl database;

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles() {
        return database.findAll();
    }

    @GetMapping("/profiles/{login}")
    public Profile getProfileByLogin(@PathVariable String login) {
        return database.findByLogin(login);
    }

    @PostMapping("/profiles")
    public void createNewProfile(@RequestBody Profile profile) {
        database.save(profile);
    }

    @DeleteMapping("/profiles/{login}")
    public void deleteProfileByLogin(@PathVariable String login) {
        database.deleteByLogin(login);
    }
}
