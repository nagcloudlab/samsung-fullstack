package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class A {
    ExecutorService theadPool = Executors.newFixedThreadPool(8);

    public CompletableFuture<String> getStep1Stuff() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Step-1";
        }, theadPool);

        return future;

    }
}

class B {
    A a = new A();
    ExecutorService theadPool = Executors.newFixedThreadPool(8);

    public void doSomething() {

        // - step-1
        CompletableFuture<String> completableFuture = a.getStep1Stuff(); // ..
        completableFuture
                .thenApplyAsync(result -> {
                    System.out.println("Step-2: with " + result);
                    return "Step-2";
                })
                .thenAcceptAsync(result -> {
                    System.out.println("Step-3: with " + result);
                }, theadPool);

        System.out.println(".....");

    }
}

public class App10 {

    public static void main(String[] args) {

        B b = new B();
        b.doSomething();

    }

}
