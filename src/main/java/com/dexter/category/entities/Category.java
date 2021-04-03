package com.dexter.category.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToMany
    @JoinTable( name = "category_to_category" ,
            joinColumns = @JoinColumn ( name = "child_category_id" , referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn ( name = "source_category_id" , referencedColumnName = "id" ))
    private List<Category> subCategories = new ArrayList<Category>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Integer id, String name, List<Category> subCategories) {
        this.id = id;
        this.name = name;
        this.subCategories = subCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
