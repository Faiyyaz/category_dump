package com.dexter.category.controller;

import com.dexter.category.entities.Category;
import com.dexter.category.entities.CategoryToCategory;
import com.dexter.category.repository.CategoryRepository;
import com.dexter.category.repository.CategoryToCategoryRepository;
import com.dexter.category.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryToCategoryRepository categoryToCategoryRepository;

    @Transactional
    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest.getName());
        category = categoryRepository.save(category);

        if(categoryRequest.getSourceCategoryId() != null) {
            categoryToCategoryRepository.save(new CategoryToCategory(categoryRequest.getSourceCategoryId(), category.getId()));
        }

        return ResponseEntity.ok(category);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return ResponseEntity.ok(categoryList);
    }
}
