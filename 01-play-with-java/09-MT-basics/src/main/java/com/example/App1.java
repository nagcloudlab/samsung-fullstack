package com.example;


// Ex: thread introduction

import java.util.Scanner;

public class App1 {
    // task-1: print number from 1 to 100
    public static void computation() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }

    // task-2: get name from user and greet him
    public static void io() {
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Good After Noon, " + name);
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " started");

        Runnable ioTask = () -> {
            io();
        };
        Thread t1 = new Thread(ioTask,"io-thread");

        Runnable computationTask = () -> {
            computation();
        };
        Thread t2 = new Thread(computationTask,"computation-thread" );

        t1.start();
        t2.start();


    }
}
