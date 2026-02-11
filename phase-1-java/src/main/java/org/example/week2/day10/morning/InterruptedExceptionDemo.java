package org.example.week2.day10.morning;


class myThreadTask implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("MyTask started running in a separate thread");
            Thread.sleep(5000);
            System.out.println("MyTask finished running in a separate thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread was interrupted during sleep");
        }
    }
}


//Main Thread
public class InterruptedExceptionDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new myThreadTask());
        t.start();
        try {
            Thread.sleep(2000); //Main thread sleeps for 2 secs
            t.interrupt(); //interrupt the thread after 2 secs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread finished");
    }
}
