package com.example;

public class JavascriptEmployee extends Employee {

    private String javascriptSkills;

    public JavascriptEmployee(int id, String name, double salary, String javascriptSkills) {
        super(id, name, salary);
        this.javascriptSkills = javascriptSkills;
    }

    public void doProgramming() {
        System.out.println(this.getName() + " doing javascript programming...with " + javascriptSkills);
    }

}
