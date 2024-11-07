package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

