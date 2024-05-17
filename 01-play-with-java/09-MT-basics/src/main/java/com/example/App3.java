package com.example;

// 1000 threads, each thread increment count 1000 times


class Counter {
    private int count = 0;

    public void increment() {
        // read count from heap
        // increment count
        // write count back to heap
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class App3 {
    public static void main(String[] args) {

        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(counter.getCount()); // 1000 * 1000 = 1000000

    }
}
