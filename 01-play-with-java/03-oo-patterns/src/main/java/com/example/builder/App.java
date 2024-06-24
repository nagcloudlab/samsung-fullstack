package com.example.builder;

public class App {
    public static void main(String[] args) {

        Employee employee =
                new Employee.Builder(1, "Alex")
                        .salary(1000)
                        .dept("IT")
                        .desg("Developer")
                        .build();

        System.out.println(employee);

    }
}
