package com.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests() // Sử dụng authorizeHttpRequests thay vì authorizeRequests
                .requestMatchers("/login", "/register", "/css/**", "/js/**", "/img/**").permitAll() // Tài nguyên công khai
                .requestMatchers("/admin/**").hasRole("ADMIN") // Chỉ cho phép ADMIN truy cập vào các URL bắt đầu bằng /admin
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // USER và ADMIN đều có thể truy cập /user
                .requestMatchers("/", "/home", "/about", "/contact").permitAll() // Các trang công khai khác
                .anyRequest().authenticated() // Bắt buộc đăng nhập cho tất cả các trang còn lại
            .and()
            .formLogin()
                .loginPage("/login") // Đường dẫn đến trang đăng nhập tùy chỉnh
                .defaultSuccessUrl("/user-home", true) // Đường dẫn sau khi đăng nhập thành công
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Đường dẫn sau khi đăng xuất thành công
                .permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
