package com.SpringStudy.SpringProject.week3.day22.evening;

public interface CategoryInterface {
    Category addCategory(Category category);
    Category getCategory(Long id);
    void editCategory(Category category);
    void deleteCategory(Long id);
}
