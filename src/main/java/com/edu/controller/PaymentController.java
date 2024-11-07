package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edu.service.PaymentService;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        model.addAttribute("paymentMethods", paymentService.getPaymentById(0));
        return "payment";
    }
}

