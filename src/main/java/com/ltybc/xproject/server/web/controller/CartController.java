package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Cart;
import com.ltybc.xproject.server.service.CartService;
import com.ltybc.xproject.server.service.ProductService;
import com.ltybc.xproject.server.service.ex.CartNotFoundException;
import com.ltybc.xproject.server.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;


    @GetMapping("{id}")
    public Cart getCartById(@PathVariable Long id) {
        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            throw new CartNotFoundException("Cart with id:" + id + " not found");
        }
        return cart;
    }

    @PostMapping("{cartId}")
    public void addProductToCart(@PathVariable Long cartId, @RequestParam Long productId) {
        if (productService.getById(productId) == null) {
            throw new ProductNotFoundException("Product with id:" + productId + " not found");
        }
        cartService.addProductToCart(cartId, productId);
    }

    @DeleteMapping("{cartId}/{productId}")
    public void deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        boolean deleted = cartService.deleteProductFromCart(cartId, productId);
        if (!deleted) {
            throw new ProductNotFoundException("Can't find productId:" + productId + " in this cart");
        }
    }
}
