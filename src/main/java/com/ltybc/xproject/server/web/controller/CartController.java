package com.ltybc.xproject.server.web.controller;

import com.ltybc.xproject.server.model.Cart;
import com.ltybc.xproject.server.service.CartService;
import com.ltybc.xproject.server.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("{id}")
    public Cart getCartById(@PathVariable Long id) {
        // TODO throw an exception if cart id can't be found
//        Cart cart = cartService.getCartById(id);
//        if (cart == null) {
//            throw new CartNotFoundException("Cart with id=" + id + " not found");
//        }
//        return cart;
        return cartService.getCartById(id);
    }

    @PostMapping("{cartId}")
    public void addProductToCart(@PathVariable Long cartId, @RequestParam Long productId) {
        // TODO throw an exception if product id has not exist
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
