package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

