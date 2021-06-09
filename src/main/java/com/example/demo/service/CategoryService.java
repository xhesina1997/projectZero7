package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public String createCategory(Category category){
        if(category != null){
            categoryRepository.save(category);
            return "Category added successfully!";
        }
        else return "Category object is empty";
    }

    public String deleteCategory(Long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        categoryRepository.delete(category.get());
        return "Category deleted successfully!";
    }
}
