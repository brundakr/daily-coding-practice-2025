package com.SpringStudy.SpringProject.week3.day15.evening;


import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Map<Integer, User> users = new HashMap<>();
    private int nextInt = 0;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User body) {
        body.setId((long) nextInt++);
        users.put(body.getId().intValue(), body);
        return body;
    }

    /// Get all
    @GetMapping
    public Collection<User> getUsers() {
        return users.values();
    }

    //Get 1 user
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.get(id);
    }

    //update an user
    @PutMapping
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        users.put(id, user);
        return user;
    }

    //Delete user
    @DeleteMapping
    public void deleteUser(@PathVariable int id) {
        users.remove(id);
    }


}
