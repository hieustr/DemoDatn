package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Orders;
import com.edu.repository.OrderRepository;
import com.edu.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders saveOrder(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
