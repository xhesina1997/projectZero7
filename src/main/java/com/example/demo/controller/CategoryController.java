package com.example.demo.controller;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping(method= RequestMethod.POST)
    public String createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @RequestMapping(value = "/delete/{categoryId}",method=RequestMethod.DELETE)
    public String deleteCategory(Long categoryId){
        return categoryService.deleteCategory(categoryId);
    }
}
