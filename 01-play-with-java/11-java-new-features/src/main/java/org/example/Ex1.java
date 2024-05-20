package org.example;

import java.util.List;

public class Ex1 {
    public static void main(String[] args) {

        List<Integer> integers= List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

    }
}
