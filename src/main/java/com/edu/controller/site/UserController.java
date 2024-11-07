package com.edu.controller.site;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // Trang dashboard của người dùng
    @GetMapping("/user/dashboard")  // Đặt URL này khác với AuthController
    public String userHome(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "site/user-home";  // Đảm bảo user-home.html tồn tại trong thư mục templates/site
    }
}
