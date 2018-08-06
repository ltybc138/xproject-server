package com.ltybc.xproject.server.dao;

import com.ltybc.xproject.server.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartDao extends CrudRepository<Cart, Long> {
    Cart getById(Long id);
    void deleteById(Long id);
}
