package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.CartItem;
import com.edu.repository.CartItemRepository;
import com.edu.service.CartItemService;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    }
}
