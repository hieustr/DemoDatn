package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Category;
import com.edu.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories") // URL để phù hợp với view front-end
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Endpoint để lấy danh sách tất cả các category và hiển thị trong trang category.html
    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category"; // Trả về tên file HTML trong thư mục templates (category.html)
    }

    // Endpoint để lấy chi tiết category theo ID và hiển thị trong trang category-detail.html
    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            model.addAttribute("category", category);
            return "category-detail"; // Trả về file HTML cho chi tiết category (category-detail.html)
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để hiển thị form thêm mới category trong trang category-form.html
    @GetMapping("/new")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form"; // Form để tạo mới category (category-form.html)
    }

    // Endpoint để xử lý thêm mới category khi submit form từ giao diện
    @PostMapping("/add")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories"; // Chuyển hướng về danh sách category sau khi thêm mới
    }

    // Endpoint để hiển thị form chỉnh sửa category
    @GetMapping("/edit/{id}")
    public String showEditCategoryForm(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            model.addAttribute("category", category);
            return "category-form"; // Dùng chung form với tạo mới
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để xử lý cập nhật category khi submit form từ giao diện
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute Category categoryDetails) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            category.setCategoryName(categoryDetails.getCategoryName());
            category.setIsActive(categoryDetails.getIsActive());
            categoryService.saveCategory(category);
            return "redirect:/categories"; // Chuyển hướng về danh sách category sau khi cập nhật
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để xử lý xóa category
    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories"; // Chuyển hướng về danh sách category sau khi xóa
    }
}
