package org.example.week1.day01.morning;

import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        System.out.println("Day01 Morning Drill");

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        intList.forEach(System.out::println);

        intList.remove(1);

        intList.forEach(System.out::println);
    }
}