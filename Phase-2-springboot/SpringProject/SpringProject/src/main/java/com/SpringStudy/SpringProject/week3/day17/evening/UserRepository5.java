package com.SpringStudy.SpringProject.week3.day17.evening;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository5 extends JpaRepository<User5, Long> {
    List<User5> findByName(String name); //custom method
}
