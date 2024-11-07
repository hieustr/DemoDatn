package com.edu.service;

import java.util.List;

import com.edu.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}