package com.edu.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "site/index"; // Trả về trang index trong thư mục site
    }

    @GetMapping("/login")
    public String login() {
        return "site/login"; // Trả về trang login trong thư mục site
    }

    @GetMapping("/user-home")
    public String userHome() {
        return "site/user-home"; // Trả về trang user-home trong thư mục site
    }
}

