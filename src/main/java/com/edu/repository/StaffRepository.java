package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}
