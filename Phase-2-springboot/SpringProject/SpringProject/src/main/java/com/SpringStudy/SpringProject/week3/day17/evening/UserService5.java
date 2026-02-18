package com.SpringStudy.SpringProject.week3.day17.evening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService5 {

    @Autowired
    private UserRepository5 userRepository;

    public User5 addUser(User5 user) {
        return userRepository.save(user);
    }

    public List<User5> findAllUsers() {
        return userRepository.findAll();
    }

    public User5 findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User5> findByName(String name) {
        return userRepository.findByName(name);
    }

}
