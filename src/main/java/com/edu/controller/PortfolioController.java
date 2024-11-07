package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    @GetMapping("/portfolio")
    public String portfolioPage(Model model) {
        return "portfolio";
    }
}

