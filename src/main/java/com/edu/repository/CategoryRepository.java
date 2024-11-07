package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

