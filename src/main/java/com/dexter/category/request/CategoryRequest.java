package com.dexter.category.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {

    private Integer id;
    private String name;
    @JsonProperty("source_category_id")
    private Integer sourceCategoryId;

    public CategoryRequest() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSourceCategoryId() {
        return sourceCategoryId;
    }
}
