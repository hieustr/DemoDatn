package com.edu.service;

import java.util.List;

import com.edu.entity.CartItem;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    CartItem getCartItemById(int id);
    CartItem saveCartItem(CartItem cartItem);
    void deleteCartItem(int id);
}