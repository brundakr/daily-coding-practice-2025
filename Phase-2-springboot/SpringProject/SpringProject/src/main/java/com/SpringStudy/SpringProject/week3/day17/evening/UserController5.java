package com.SpringStudy.SpringProject.week3.day17.evening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api5/user5")
public class UserController5 {

    @Autowired
    private UserService5 userService;

    @PostMapping("/addUser")
    public User5 saveUser(@RequestBody User5 user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAllUsers")
    public Collection<User5> getAllUsers() {
        return  userService.findAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User5 getUser(@PathVariable Long id) {
        return userService.findUser(id);
    }


}
