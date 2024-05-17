package com.example;

class R1 {
    public synchronized void m1(R2 r1) {
        System.out.println("T1 having r1");
        System.out.println("T1 trying for R2");
        r1.m2();
    }

    public synchronized void m2() {
        System.out.println("T2 also having r1");
    }
}

class R2 {
    public synchronized void m1(R1 r1) {
        System.out.println("T2 having r2");
        System.out.println("T2 trying for R1");
        r1.m2();
    }

    public synchronized void m2() {
        System.out.println("T1 also having r2");
    }
}

public class App5 {
    public static void main(String[] args) {

        R1 r1 = new R1();
        R2 r2 = new R2();

        Thread t1 = new Thread(() -> {
            r1.m1(r2);
        }, "T1");

        Thread t2 = new Thread(() -> {
            r2.m1(r1);
        }, "T2");

        t1.start();
        t2.start();

    }
}

