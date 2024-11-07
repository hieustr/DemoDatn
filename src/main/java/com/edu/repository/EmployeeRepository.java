package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Thêm các phương thức truy vấn tùy chỉnh nếu cần thiết
}

