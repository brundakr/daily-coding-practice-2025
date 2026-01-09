package org.example.week1.day01.evening;

public class Student {
    private String name;
    private int age;
    private char grade;

    public Student(String name, int age, char grade) {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if(grade < 'A' || grade > 'E') {
            throw new IllegalArgumentException("Grade must be between 'A' and 'E'");
        }
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGrade() {
        return grade;
    }
}
