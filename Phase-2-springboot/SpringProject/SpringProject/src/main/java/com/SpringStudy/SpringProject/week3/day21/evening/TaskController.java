package com.SpringStudy.SpringProject.week3.day21.evening;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taskManagement")
public class TaskController {


    @Autowired
    private TaskManagementService taskManagementService;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        System.out.println(task);
        return taskManagementService.addTask(task);
    }

    @GetMapping("/getTask/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskManagementService.findTask(id);
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() {
        return taskManagementService.findAll();
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
         taskManagementService.deleteTaskById(id);    }


}
