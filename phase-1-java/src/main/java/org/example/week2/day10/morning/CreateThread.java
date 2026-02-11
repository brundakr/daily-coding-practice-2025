package org.example.week2.day10.morning;


class MyTask implements Runnable {
    public void run() {
        System.out.println("Task running in a separate thread");
    }
}


public class CreateThread {
    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}
