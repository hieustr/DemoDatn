package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

