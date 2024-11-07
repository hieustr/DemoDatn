package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComplaintController {

    @GetMapping("/complaint")
    public String complaintPage(Model model) {
        return "complaint";
    }
}

