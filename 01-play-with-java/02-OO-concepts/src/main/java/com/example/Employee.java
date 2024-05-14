package com.example;


public abstract class Employee  {

    // a. variables

    // 1. static variables
    public final static String COMPANY_NAME = "samsung"; // constant & common for all objects
    public static String tnrName; // common for all objects
    // 2. instance variables
    private int id;
    private String name;
    private double salary;

    // b. constructors
    // 1. default constructor
//    public Employee() {
//        System.out.println("Employee() - default constructor");
//    }
    // 2. parameterized constructor(s)
    public Employee(int id) {
        this(id, "Unknown", 0.0); // calling another constructor ( constructor chaining
    }

    public Employee(int id, String name) {
        this(id, name, 0.0); // calling another constructor ( constructor chaining
    }

    public Employee(int id, String name, double salary) {
        if (id <= 0) {
            throw new IllegalArgumentException("id should be +ve number");
        }
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("name is required");
        }
        if (salary < 0.0) {
            throw new IllegalArgumentException("salary should be +ve number");
        }
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // c. methods
    // 1. class methods
    public static void doTeach() {
        System.out.println(tnrName + " teaching...");
    }

    // 2. instance methods
    public void doListen() {
        System.out.println(this.name + " listening...");
    }
    public abstract void doProgramming();

    // accessor methods ( getter/setter methods)
    public int getId() {
        return id;
    }
    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSalary(double salary) {
        if (salary < 0.0) {
            throw new IllegalArgumentException("salary should be +ve number");
        }
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';

    }

    // d. inner classes
    // 1. static inner class
    // 2. non-static inner class

    // e. blocks
    // 1. static block
    // 2. instance block


}