package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

