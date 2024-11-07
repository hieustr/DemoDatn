package com.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.edu.entity.Role;
import com.edu.entity.User;
import com.edu.repository.RoleRepository;
import com.edu.repository.UserRepository;

@SpringBootApplication
public class Datn2025Application {

    public static void main(String[] args) {
        SpringApplication.run(Datn2025Application.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Khởi tạo dữ liệu mẫu cho vai trò và người dùng
            Role adminRole;
            Role userRole;

            if (!roleRepository.existsByName("ROLE_ADMIN")) {
                adminRole = roleRepository.save(new Role("ROLE_ADMIN"));
            } else {
                adminRole = roleRepository.findByName("ROLE_ADMIN").orElse(null);
            }

            if (!roleRepository.existsByName("ROLE_USER")) {
                userRole = roleRepository.save(new Role("ROLE_USER"));
            } else {
                userRole = roleRepository.findByName("ROLE_USER").orElse(null);
            }

            User admin = new User("admin", passwordEncoder.encode("admin123"), true);
            admin.getRoles().add(adminRole);

            User user = new User("user", passwordEncoder.encode("user123"), true);
            user.getRoles().add(userRole);

            if (!userRepository.existsByUsername("admin")) {
                userRepository.save(admin);
            }
            if (!userRepository.existsByUsername("user")) {
                userRepository.save(user);
            }
        };
    }
}
