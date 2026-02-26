package com.SpringStudy.SpringProject.week3.day22.evening;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CategoryInterface {

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Category addCategory(Category category) {
        //set Task aswell - works vis cascade
        if(category.getTasks() != null) {
            category.getTasks().forEach(task -> task.setCategory(category));
        }
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepo.findById(id)
                .orElse(null);
    }

    @Override
    public void editCategory(Category category) {
        Category category1 = categoryRepo.findById(category.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        category1.setCategoryName(category.getCategoryName());
        categoryRepo.save(category1);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }


}
