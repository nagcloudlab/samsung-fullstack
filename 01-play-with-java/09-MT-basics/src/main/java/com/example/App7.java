package com.example;


// Executor Framework  ( e.g Thread pools )

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App7 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        // submit 10  tasks to the executor service
        for (int i = 0; i < 8; i++) {
            executorService.submit(new Task(i));
        }
    }
}


class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
    }
}