package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Cart;
import com.ltybc.xproject.server.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }
}
