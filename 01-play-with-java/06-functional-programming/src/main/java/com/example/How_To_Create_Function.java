package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class How_To_Create_Function {
    public static void main(String[] args) {

        // Type fn=input -> output/side-effect
        // Type => FunctionalInterface
        // FunctionalInterface => a interface with only one abstract method
        // built-in FunctionalInterface => Predicate, Consumer, Function, Supplier ( java.util.function )

        Function<Integer, Integer> add = (a) -> a + 1;
        BiFunction<Integer, Integer, Integer> add2 = (a, b) -> a + b;
        Predicate<Integer> isEven = (a) -> a % 2 == 0;
        Consumer<Integer> print = (a) -> System.out.println(a);
        Supplier<Integer> random = () -> (int) (Math.random() * 100);


        System.out.println(add.apply(1));
        System.out.println(add2.apply(1, 2));
        System.out.println(isEven.test(2));
        print.accept(1);
        System.out.println(random.get());

        UnaryOperator<Integer> add3 = (a) -> a + 1;
        BinaryOperator<Integer> add4 = (a, b) -> a + b;

        System.out.println(add3.apply(1));
        System.out.println(add4.apply(1, 2));

        // java is not pure object-oriented language
        // still we do arithmetics with primitive types

//        int a = 1;
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        System.out.println(list.get(0)+10);
//
//        // i.e boxing and unboxing

        IntBinaryOperator add5 = (a, b) -> a + b;
        LongBinaryOperator add6 = (a, b) -> a + b;
        DoubleBinaryOperator add7 = (a, b) -> a + b;

        System.out.println(add5.applyAsInt(1, 2));
        System.out.println(add6.applyAsLong(1, 2));
        System.out.println(add7.applyAsDouble(1, 2));

    }
}
