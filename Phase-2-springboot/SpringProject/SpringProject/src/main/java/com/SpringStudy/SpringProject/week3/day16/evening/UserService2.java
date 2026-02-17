package com.SpringStudy.SpringProject.week3.day16.evening;


import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService2 implements UserInterface {
    private Map<Integer, User> users = new HashMap<>();
    private int nextInt = 0;


    @Override
    public User addUser(User body) {
        body.setId((long) nextInt++);
        users.put(body.getId().intValue(), body);
        return body;
    }

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public User updateUser(int id, User user) {
        users.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        users.remove(id);
    }
}
