package com.example;

// Ex: thread lifecycle

public class App2 {
    public static void main(String[] args) {

        Runnable task = () -> {
            // print number b/w 1 to 100
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }

            // WAITING
            // TIMED_WAITING
            // BLOCKED

        }; // TERMINATED

        Thread thread1 = new Thread(task, "T1"); // NEW
        Thread thread2 = new Thread(task, "T2");
        Thread thread3 = new Thread(task, "T3");

        thread1.start(); // RUNNABLE
        thread2.start();
        thread3.start();


    }
}
