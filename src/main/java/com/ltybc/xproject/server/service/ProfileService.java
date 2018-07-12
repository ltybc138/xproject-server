package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> findAll();
    Profile findByLogin(String login);
    void save(Profile profile);
    void deleteByLogin(String login);
}
