package com.example;

/*
    - A function can be stored in a variable
    - A parameter of a function can be a function
    - The return value of a function can be a function
 */

import java.util.function.Predicate;

public class Function_Principles {

    public static Predicate<Integer> and(Predicate<Integer> isMin, Predicate<Integer> isMax) {
        return n -> isMin.test(n) & isMax.test(n);
    }

    public static void main(String[] args) {

        Predicate<Integer> isMin = (number) -> number > 10;
        Predicate<Integer> isMax = (number) -> number < 100;

        Predicate<Integer> andPredicate = and(isMin, isMax);
        System.out.println(andPredicate.test(50));

        int v = 12;
        String str = "hello";
        Predicate<String> isEmpty = s -> s != null & s.isEmpty();


    }
}
