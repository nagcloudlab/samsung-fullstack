package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class GreenApplesPredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.color());
    }
}

public class App {

    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple("green", 150),
                new Apple("red", 120),
                new Apple("green", 170),
                new Apple("red", 140),
                new Apple("green", 160),
                new Apple("red", 130)
        );

        // way-1
        System.out.println(
                filterApples(inventory, new GreenApplesPredicate())
        );

        // way-2 : Anonymous class
        System.out.println(
                filterApples(inventory, new Predicate<Apple>() {
                    @Override
                    public boolean test(Apple apple) {
                        return "red".equals(apple.color());
                    }
                })
        );


        // way-3 : Lambda ( Java 1.8 )
        System.out.println(
                filterApples(inventory, apple -> "red".equals(apple.color())) // Behaviour parameterization
        );


    }

    // How to filter apples ?
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}
