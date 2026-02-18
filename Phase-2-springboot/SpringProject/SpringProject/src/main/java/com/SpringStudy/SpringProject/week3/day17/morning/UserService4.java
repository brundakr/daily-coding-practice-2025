package com.SpringStudy.SpringProject.week3.day17.morning;

import com.SpringStudy.SpringProject.week3.day16.evening.User;
import com.SpringStudy.SpringProject.week3.day16.evening.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService4 {

    @Autowired
    private UserRepository4 userRepository4;

    public User4 addUser(User4 body){
        return userRepository4.save(body);
    }


    public List<User4> getUsers4() {
        return userRepository4.findAll();
    }

    public User4 getUser(Long id) {
        return userRepository4.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository4.deleteById(id);
    }

}
