package com.example;

import java.util.concurrent.TimeUnit;

class Building {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public void room1() {
       synchronized (lock1){
           String threadName = Thread.currentThread().getName();
           System.out.println(threadName + " building room1");
           try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println(threadName + " building room1 done");
       }
    }

    public void room2() {
        synchronized (lock2){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " building room2");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadName + " building room2 done");
        }
    }

}

public class App4 {

    public static void main(String[] args) {

        Building building1 = new Building();
        Building building2 = new Building();

        Runnable room1Worker = () -> {
            building1.room1();
        };
        Runnable room2Worker = () -> {
            building2.room2();
        };

        Thread room1Thread1 = new Thread(room1Worker, "T1");
        Thread room1Thread2 = new Thread(room1Worker, "T2");

        Thread room2Thread1 = new Thread(room2Worker, "T3");

        room1Thread1.start();
        room1Thread2.start();
        room2Thread1.start();
    }

}
