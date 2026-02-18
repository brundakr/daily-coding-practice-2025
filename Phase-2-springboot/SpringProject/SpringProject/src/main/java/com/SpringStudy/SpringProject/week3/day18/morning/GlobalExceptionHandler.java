package com.SpringStudy.SpringProject.week3.day18.morning;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

}
