package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Employee;
import com.edu.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees") // Định tuyến đến trang employees trên front-end
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Hiển thị danh sách tất cả nhân viên trong trang employees.html
    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees"; // Tên file HTML trong thư mục templates (employees.html)
    }

    // Hiển thị chi tiết nhân viên theo ID trong trang employee-detail.html
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-detail"; // Tên file HTML cho chi tiết nhân viên
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Hiển thị form để tạo nhân viên mới
    @GetMapping("/new")
    public String showCreateEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form"; // Tên file HTML cho form tạo mới nhân viên (employee-form.html)
    }

    // Xử lý việc tạo nhân viên mới từ form
    @PostMapping("/add")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees"; // Chuyển hướng về danh sách nhân viên sau khi thêm mới
    }

    // Hiển thị form để chỉnh sửa nhân viên
    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-form"; // Sử dụng chung form với form tạo mới
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Xử lý cập nhật thông tin nhân viên từ form
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute Employee employeeDetails) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setDateOfBirth(employeeDetails.getDateOfBirth());
            employee.setGender(employeeDetails.getGender());
            employee.setPhone(employeeDetails.getPhone());
            employee.setEmail(employeeDetails.getEmail());
            employee.setAddress(employeeDetails.getAddress());
            employee.setPosition(employeeDetails.getPosition());
            employee.setHireDate(employeeDetails.getHireDate());
            employee.setSalary(employeeDetails.getSalary());
            employeeService.saveEmployee(employee);
            return "redirect:/employees"; // Chuyển hướng về danh sách nhân viên sau khi cập nhật
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Xử lý xóa nhân viên
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees"; // Chuyển hướng về danh sách nhân viên sau khi xóa
    }
}
