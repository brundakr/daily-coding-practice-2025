package com.SpringStudy.SpringProject.week3.day21.evening;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskGlobalException {

    @ExceptionHandler
    public ResponseEntity<String> handleTaskNotFound(TaskNotFound ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }


}
