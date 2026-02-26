package com.SpringStudy.SpringProject.week3.day23.morning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService23 {

    @Autowired
    private TaskRepo23 taskRepo23;

    public Page<Task23> getLimitedTasks(int page, int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("taskName").descending());
        return taskRepo23.findAll(pageable);
    }


}
