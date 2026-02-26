package com.SpringStudy.SpringProject.week3.day22.evening;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Task2> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Task2> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task2> tasks) {
        this.tasks = tasks;
    }

    public String toString(Category category) {
        return "Category name: " + category.getCategoryName();
    }

}
