package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceHardcodedImpl implements ProfileService {
    private List<Profile> database;

    public ProfileServiceHardcodedImpl() {
        database = new ArrayList<>();
        database.add(new Profile("login", "password"));
        database.add(new Profile("denis", "password"));
        database.add(new Profile("ltybc", "password"));
        database.add(new Profile("admin", "password"));
        database.add(new Profile("coder", "password"));
    }

    @Override
    public List<Profile> findAll() {
        return database;
    }

    @Override
    public Profile findByLogin(String login) {
        Profile profile = null;
        for (Profile p : database) {
            if (p.getLogin().equals(login))
                profile = p;
        }
        return profile;
    }

    @Override
    public void save(Profile profile) {
        database.add(profile);
    }

    @Override
    public void deleteByLogin(String login) {
        for (int i = 0; i < database.size(); i++) {
            Profile p = database.get(i);
            if (p.getLogin().equals(login)) {
                database.remove(i);
            }
        }
    }
}
