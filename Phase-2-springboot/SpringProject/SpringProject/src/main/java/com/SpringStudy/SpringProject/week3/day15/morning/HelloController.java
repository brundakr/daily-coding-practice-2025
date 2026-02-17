package com.SpringStudy.SpringProject.week3.day15.morning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/jsonResponse")
    public Map<String, String> getResponse(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World!");
        return response;
    }

}
