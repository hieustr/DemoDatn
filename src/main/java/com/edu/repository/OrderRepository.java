package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

