package com.edu.service;

import java.util.List;

import com.edu.entity.Payment;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(int id);
    Payment savePayment(Payment payment);
    void deletePayment(int id);
}