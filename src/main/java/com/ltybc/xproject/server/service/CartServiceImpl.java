package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.CartDao;
import com.ltybc.xproject.server.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(Long id) {
        return cartDao.getById(id);
    }
}
