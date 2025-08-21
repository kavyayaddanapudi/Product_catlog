package com.myapp.productcatalog.service;

import com.myapp.productcatalog.model.Category;
import com.myapp.productcatalog.repository.CategoryRepository;
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

    
    public Category createCategory(Category category) {
       
        if (category.getAttributes() != null) {
            category.getAttributes().forEach(attribute -> attribute.setCategory(category));
        }
        return categoryRepository.save(category);
    }

    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }
}