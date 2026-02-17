package com.SpringStudy.SpringProject.week3.day16.evening;

import java.util.Collection;

public interface UserInterface {
    User addUser(User body);
    Collection<User> getUsers();
    User getUser(int id);
    User updateUser(int id, User user);
    void deleteUser(int id);
}
