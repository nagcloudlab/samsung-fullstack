package com.example;

import java.util.concurrent.ArrayBlockingQueue;

// Ex. Wait Notify | Producer Consumer Pattern

// buffer with 10 elements
// producer will produce 50 elements
// consumer will consume 45 elements

// producer will wait if buffer is full
// consumer will wait if buffer is empty

// producer will notify consumer if it produces an element
// consumer will notify producer if it consumes an element

// producer produce element every 1s,
// consumer consume element every 2s

// Write code for above scenario using ArrayBlockingQueue

class Demo {

    private ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);

    public void producer() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void consumer() {
        new Thread(() -> {
            for (int i = 0; i < 45; i++) {
                try {
                    int element = buffer.take();
                    System.out.println("Consumed: " + element);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}


public class App9 {
    public static void main(String[] args) {

        Demo demo = new Demo();
        Thread t1 = new Thread(() -> {
            demo.producer();
        });

        Thread t2 = new Thread(() -> {
            demo.consumer();
        });

        t1.start();
        t2.start();

    }
}
