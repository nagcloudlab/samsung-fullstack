package org.example;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex9 {
    public static void main(String[] args) {


        Function<String, String> function = ( var str) -> {
            return str;
        };

        String str = " Hello ";
        System.out.println(str.isBlank()); // false
        System.out.println(str.strip());   // "Hello"
        System.out.println("abc\nxyz".lines().collect(Collectors.toList())); //


        String multiline = """
                This is a multiline
                string
                """; // This is a multiline\nstring\n

    }
}
