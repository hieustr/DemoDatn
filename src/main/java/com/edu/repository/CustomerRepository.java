package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}
