package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

