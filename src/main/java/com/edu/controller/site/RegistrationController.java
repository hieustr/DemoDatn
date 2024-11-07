package com.edu.controller.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.entity.User;
import com.edu.repository.RoleRepository;
import com.edu.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "site/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "site/register";
        }

        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.getRoles().add(roleRepository.findByName("ROLE_USER").orElse(null)); // Gán role mặc định cho user

        userRepository.save(user);

        model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "redirect:/login";
    }
}
