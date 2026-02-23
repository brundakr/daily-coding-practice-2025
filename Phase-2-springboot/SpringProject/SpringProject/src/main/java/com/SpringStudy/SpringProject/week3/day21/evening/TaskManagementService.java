package com.SpringStudy.SpringProject.week3.day21.evening;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManagementService {

    @Autowired
    private TaskManagementRepository taskManagementRepository;

    public Task addTask(Task task) {
        return taskManagementRepository.save(task);
    }


    public Task findTask(Long id) {
        return taskManagementRepository.findById(id)
                .orElseThrow(() -> new TaskNotFound("Task not found"));
    }

    public List<Task> findAll() {
        return taskManagementRepository.findAll();
    }

    public void deleteTaskById(Long id) {
        taskManagementRepository.deleteById(id);
    }


}
