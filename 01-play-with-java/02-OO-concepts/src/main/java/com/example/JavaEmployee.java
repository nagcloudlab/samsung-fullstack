package com.example;

//if Type2 IS-A Type1, then Type2 is a subclass of Type1.

public class JavaEmployee extends Employee{

    private String javaSkills;

    public JavaEmployee(int id, String name, double salary, String javaSkills) {
        super(id, name, salary);
        this.javaSkills = javaSkills;
    }

    public void doProgramming() {
        System.out.println(this.getName() + " doing programming...with " + javaSkills);
    }

}
