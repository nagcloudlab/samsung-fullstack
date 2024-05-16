package com.example;

import java.util.ArrayList;
import java.util.List;

public class App7 {
    public static void main(String[] args) {

        List<String>  mutableList = new ArrayList<>();
        mutableList.add("A");
        mutableList.add("B");

        List<String> immutableList = List.of("A", "B");
        immutableList.add("C"); // UnsupportedOperationException

    }
}
