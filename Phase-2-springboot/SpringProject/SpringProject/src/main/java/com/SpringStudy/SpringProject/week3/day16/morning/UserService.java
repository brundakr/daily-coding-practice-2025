package com.SpringStudy.SpringProject.week3.day16.morning;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    private int nextInt = 0;

    public User addUser(User body) {
        body.setId((long) nextInt++);
        users.put(body.getId().intValue(), body);
        return body;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public User updateUser(int id, User user) {
        users.put(id, user);
        return user;
    }

    public void deleteUser(int id) {
        users.remove(id);
    }
}
