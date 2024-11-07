package com.edu.service;

import java.util.List;

import com.edu.entity.Cart;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCartById(int id);
    Cart saveCart(Cart cart);
    void deleteCart(int id);
}