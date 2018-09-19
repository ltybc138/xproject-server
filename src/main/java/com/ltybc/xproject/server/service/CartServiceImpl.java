package com.ltybc.xproject.server.service;

import com.ltybc.xproject.server.dao.CartDao;
import com.ltybc.xproject.server.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartDao cartDao;

    @Autowired
    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public Cart getCartById(Long id) {
        return cartDao.getById(id);
    }

    @Override
    public void addProductToCart(Long cartId, Long productId) {
        Cart cart = cartDao.getById(cartId);
        List<Long> products = cart.getProducts();
        products.add(productId);
        cart.setProducts(products);
        cartDao.save(cart);
    }

    @Override
    public boolean deleteProductFromCart(Long cartId, Long productId) {
        Cart cart = cartDao.getById(cartId);
        List<Long> products = cart.getProducts();
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(productId)) {
                toRemove.add(i);
            }
        }

        boolean deleted = false;
        for (int i : toRemove) {
            products.remove(i);
            deleted = true;
        }
        
        cart.setProducts(products);
        cartDao.save(cart);
        return deleted;
    }
}
