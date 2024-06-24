package com.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class HOF {

    public static void main(String[] args) {

        Consumer<String> sayHi = name -> {
            System.out.println("hi " + name);
//            System.out.println("😀");
        };

        Consumer<String> sayHello = name -> {
            System.out.println("hello " + name);
//            System.out.println("😀");
        };

        // design issues
        // code tangling
        // code scattering

        // solution: using HOF
        UnaryOperator<Consumer<String>> withEmoji=f->{
            return name->{
                f.accept(name);
                System.out.println("😀");
            };
        };


        sayHi.accept("foo");
        withEmoji.apply(sayHi).accept("bar");

        // HOF -> by composition, we can build complex algo as we need

    }
}
