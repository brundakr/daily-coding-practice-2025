package org.example.week2.day10.morning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceClass {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(() -> System.out.println("Task 1 running in a separate thread"));
        pool.submit(() -> System.out.println("Task 2 running in a separate thread"));
        pool.shutdown();
    }
}
