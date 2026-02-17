package com.SpringStudy.SpringProject.week3.day16.evening;


import com.SpringStudy.SpringProject.week3.day16.morning.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api3/users3")
public class UserController3 {
    @Autowired
    private UserService2 userService;

    @PostMapping("/addUser3")
    public User addUser(@RequestBody User body) {
        return userService.addUser(body);
    }

    /// Get all
    @GetMapping
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    //Get 1 user
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    //update an user
    @PutMapping
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    //Delete user
    @DeleteMapping
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}