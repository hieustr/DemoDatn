package com.edu.service;

import java.util.List;

import com.edu.entity.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();         // Lấy danh sách tất cả khách hàng
    Customer getCustomerById(int id);         // Lấy thông tin chi tiết của một khách hàng theo ID
    Customer saveCustomer(Customer customer); // Tạo mới hoặc cập nhật thông tin khách hàng
    void deleteCustomer(int id);              // Xóa một khách hàng theo ID
}
