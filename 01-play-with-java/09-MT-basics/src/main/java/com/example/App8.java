package com.example;

import java.util.Random;
import java.util.concurrent.*;

class RandomNumberTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        Random random = new Random(100);
        return random.nextInt();
    }
}

public class App8 {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Callable<Integer> callableTask = new RandomNumberTask();
        Future<Integer> future=executorService.submit(callableTask);

        System.out.println("Waiting for the result...");

        Integer result = future.get();
        System.out.println("Random number: " + result);


    }
}
