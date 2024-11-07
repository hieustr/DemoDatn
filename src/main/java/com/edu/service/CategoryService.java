package com.edu.service;

import java.util.List;

import com.edu.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category saveCategory(Category category);
    void deleteCategory(int id);
}