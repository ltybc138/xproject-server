package com.ltybc.xproject.server.dao;

import com.ltybc.xproject.server.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    void deleteByLogin(String login);
}
