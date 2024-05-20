package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex7 {
    public static void main(String[] args) {

        // 1. Create a list of 1M employees sorted by salary
        java.util.List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 2*1000000; i++) {
            employees.add(new Employee("name" + i, 23, i * 100));
        }

        // 2. filter employees where salary < 5000
        long start = System.currentTimeMillis();
        List<Employee> filteredEmployees = employees.stream()
                .takeWhile(e -> e.getSalary() < 5000)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
        System.out.println(filteredEmployees.size());


    }
}
