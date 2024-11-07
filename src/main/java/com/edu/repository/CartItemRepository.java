package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

