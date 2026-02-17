package com.SpringStudy.SpringProject.week3.day16.evening;

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String email;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString(User user) {
        return "User name: " + user.getName() + ", email: " + user.getEmail();
    }

    public boolean equals(User user) {
        if(this == user) {
            return true;
        }
        if(!(user instanceof User)) {
            return false;
        }
        User user2 = (User) user;
        return Objects.equals(this.email, user2.email) && Objects.equals(this.name, user2.name);
    }

    public int hashCode(){
        return Objects.hash(this.email, this.name);
    }
}
