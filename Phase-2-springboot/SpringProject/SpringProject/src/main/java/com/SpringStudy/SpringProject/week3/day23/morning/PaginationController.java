package com.SpringStudy.SpringProject.week3.day23.morning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api23/Pagination")
public class PaginationController {

    @Autowired
    private TaskService23 taskService23;

    @GetMapping("/getTasks")
    public Page<Task23> getTasks(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size){

        return taskService23.getLimitedTasks(page, size);


    }




}
