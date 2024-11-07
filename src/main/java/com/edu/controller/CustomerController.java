package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Customer;
import com.edu.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers") // Định tuyến đến trang khách hàng trên front-end
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Hiển thị danh sách tất cả các khách hàng trong trang customers.html
    @GetMapping
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers"; // Tên file HTML trong thư mục templates (customers.html)
    }

    // Hiển thị chi tiết khách hàng theo ID trong trang customer-detail.html
    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer-detail"; // Tên file HTML cho chi tiết khách hàng
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Hiển thị form để tạo khách hàng mới
    @GetMapping("/new")
    public String showCreateCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form"; // Tên file HTML cho form tạo mới khách hàng (customer-form.html)
    }

    // Xử lý việc tạo khách hàng mới từ form
    @PostMapping("/add")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers"; // Chuyển hướng về danh sách khách hàng sau khi thêm mới
    }

    // Hiển thị form để chỉnh sửa khách hàng
    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer-form"; // Sử dụng chung form với form tạo mới
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Xử lý cập nhật thông tin khách hàng từ form
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable int id, @ModelAttribute Customer customerDetails) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            customer.setGender(customerDetails.getGender());
            customer.setPhone(customerDetails.getPhone());
            customer.setEmail(customerDetails.getEmail());
            customer.setAddress(customerDetails.getAddress());
            customer.setIsActive(customerDetails.getIsActive());
            customerService.saveCustomer(customer);
            return "redirect:/customers"; // Chuyển hướng về danh sách khách hàng sau khi cập nhật
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Xử lý xóa khách hàng
    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers"; // Chuyển hướng về danh sách khách hàng sau khi xóa
    }
}
