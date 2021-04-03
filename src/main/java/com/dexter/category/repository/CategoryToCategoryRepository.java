package com.dexter.category.repository;

import com.dexter.category.entities.CategoryToCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryToCategoryRepository extends JpaRepository<CategoryToCategory, Integer> {
}
