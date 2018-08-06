package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart getCartById(Long id);
}
