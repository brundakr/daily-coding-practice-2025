package com.SpringStudy.SpringProject.week3.day18.morning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api6/users6")
public class UserController6 {

    @Autowired
    private UserService6 userService6;

    @GetMapping("/user/{id}")
    public User6 getUser(@PathVariable Long id) {
        return userService6.getUser(id);
    }

}
