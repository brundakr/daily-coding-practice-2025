package com.SpringStudy.SpringProject.week3.day18.morning;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is mandatory")
    @Size(min=2, max = 15, message = "Name must be 2-50 characters")
    private String name;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;



}
