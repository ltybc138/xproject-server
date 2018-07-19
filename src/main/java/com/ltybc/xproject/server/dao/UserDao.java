package com.ltybc.xproject.server.dao;

import com.ltybc.xproject.server.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByLogin(String login);
    void deleteByLogin(String login);
}
