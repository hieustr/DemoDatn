package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Orders;
import com.edu.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int id) {
        Orders orders = orderService.getOrderById(id);
        if (orders != null) {
            return ResponseEntity.ok(orders);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders orders) {
        return orderService.saveOrder(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable int id, @RequestBody Orders orderDetails) {
        Orders order = orderService.getOrderById(id);
        if (order != null) {
            order.setOrderDate(orderDetails.getOrderDate());
            order.setScheduledDate(orderDetails.getScheduledDate());
            order.setTotalPrice(orderDetails.getTotalPrice());
            order.setPaymentStatus(orderDetails.getPaymentStatus());
            order.setOrderStatus(orderDetails.getOrderStatus());
            return ResponseEntity.ok(orderService.saveOrder(order));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
