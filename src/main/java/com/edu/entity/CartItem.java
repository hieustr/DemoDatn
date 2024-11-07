package com.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemID;

    @ManyToOne
    @JoinColumn(name = "cartID", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "serviceID", nullable = false)
    private Services service;

    private Integer quantity;
    private Double price;
    private String notes;

    // Getters and Setters
    public Integer getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(Integer cartItemID) {
        this.cartItemID = cartItemID;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

