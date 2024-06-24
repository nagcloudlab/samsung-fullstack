package com.example;


import java.util.function.Consumer;

class Abc {
    static int staVar = 1;
    int insVar = 2;
    public Consumer<String> getConsumer(int v) {
        int localVar=4;
        Consumer<String> consumer = name -> {
            System.out.println("hello " + name);
            System.out.println(staVar);
            System.out.println(insVar);
            System.out.println(v);
            System.out.println(localVar);
        };
        return consumer;
    }
}


public class How_To_Capture_Variable {

    public static void main(String[] args) {

        Consumer<String> consumer=new Abc().getConsumer(3);
        consumer.accept("foo");

    }

}
