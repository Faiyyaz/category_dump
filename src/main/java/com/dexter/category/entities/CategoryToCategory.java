package com.dexter.category.entities;

import javax.persistence.*;

@Entity
@Table(name = "category_to_category")
public class CategoryToCategory {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "source_category_id")
    private Integer sourceCategoryId;

    @Column(name = "child_category_id")
    private Integer childCategoryId;

    public CategoryToCategory() {
    }

    public CategoryToCategory(Integer sourceCategoryId, Integer childCategoryId) {
        this.sourceCategoryId = sourceCategoryId;
        this.childCategoryId = childCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceCategoryId() {
        return sourceCategoryId;
    }

    public void setSourceCategoryId(Integer sourceCategoryId) {
        this.sourceCategoryId = sourceCategoryId;
    }

    public Integer getChildCategoryId() {
        return childCategoryId;
    }

    public void setChildCategoryId(Integer childCategoryId) {
        this.childCategoryId = childCategoryId;
    }
}
