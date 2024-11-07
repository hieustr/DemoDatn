package com.edu.service;

import java.util.List;

import com.edu.entity.Orders;

public interface OrderService {
    List<Orders> getAllOrders();
    Orders getOrderById(int id);
    Orders saveOrder(Orders orders);
    void deleteOrder(int id);
}