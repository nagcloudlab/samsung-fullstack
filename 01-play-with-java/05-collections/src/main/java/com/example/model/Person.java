package com.example.model;

public record Person(String name, int age) {
    // hashCode() and equals() are automatically generated
    // by the compiler

    // toString() is also automatically generated

    // You can add more methods here
    public void print() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
