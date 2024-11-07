package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Services;
import com.edu.service.ServicesService;

import java.util.List;

@Controller("serviceControllerHome")
@RequestMapping("/services") // Chuyển đổi URL để phù hợp với view front-end
public class ServiceController {

    private final ServicesService servicesService;

    @Autowired
    public ServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    // Endpoint để lấy danh sách các dịch vụ và hiển thị trong trang service.html
    @GetMapping
    public String getAllServices(Model model) {
        List<Services> services = servicesService.getAllServices();
        model.addAttribute("services", services);
        return "service"; // Trả về tên của file HTML trong thư mục templates (service.html)
    }

    // Endpoint để lấy chi tiết một dịch vụ cụ thể và hiển thị trong trang service-detail.html
    @GetMapping("/{id}")
    public String getServiceById(@PathVariable int id, Model model) {
        Services service = servicesService.getServiceById(id);
        if (service != null) {
            model.addAttribute("service", service);
            return "service-detail"; // Trả về tên của file HTML trong thư mục templates (service-detail.html)
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để thêm mới một dịch vụ (phục vụ qua form submit từ giao diện)
    @PostMapping("/add")
    public String createService(@ModelAttribute Services service) {
        servicesService.saveService(service);
        return "redirect:/services"; // Sau khi thêm mới, chuyển hướng lại danh sách dịch vụ
    }

    // Endpoint để cập nhật một dịch vụ cụ thể (phục vụ qua form submit từ giao diện)
    @PostMapping("/update/{id}")
    public String updateService(@PathVariable int id, @ModelAttribute Services serviceDetails) {
        Services service = servicesService.getServiceById(id);
        if (service != null) {
            service.setServiceName(serviceDetails.getServiceName());
            service.setDescription(serviceDetails.getDescription());
            service.setIsActive(serviceDetails.getIsActive());
            servicesService.saveService(service);
            return "redirect:/services"; // Sau khi cập nhật, chuyển hướng lại danh sách dịch vụ
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để xóa một dịch vụ (phục vụ qua form submit hoặc nút delete từ giao diện)
    @PostMapping("/delete/{id}")
    public String deleteService(@PathVariable int id) {
        servicesService.deleteService(id);
        return "redirect:/services"; // Sau khi xóa, chuyển hướng lại danh sách dịch vụ
    }
}
