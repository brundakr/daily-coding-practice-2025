package com.SpringStudy.SpringProject.week3.day18.morning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService6 {

    @Autowired
    private UserRepository6 userRepository6;

    public User6 getUser(Long id) {
        return userRepository6.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }


}
