package org.example.week1.day01.evening;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Ariana", 32, 'A'));
        students.add(new Student("Bianca", 28, 'B'));
        students.add(new Student("Clara", 35, 'C'));
        students.add(new Student("Diana", 26, 'D'));
        students.add(new Student("Elle", 12, 'E'));

        findStudentsByGrade(students, 'A');
    }

    private static void findStudentsByGrade(List<Student> students, char grade) {
        students.stream()
        .filter(s -> s.getGrade() == grade)
        .forEach(s -> System.out.println(s.getName()));
    }


}
