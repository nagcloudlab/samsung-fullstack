package com.example;

public class PythonEmployee extends Employee {

    private String pythonSkills;

    public PythonEmployee(int id, String name, double salary, String pythonSkills) {
        super(id, name, salary);
        this.pythonSkills = pythonSkills;
    }

    @Override
    public void doProgramming() {
        System.out.println(this.getName() + " doing python programming...with " + pythonSkills);
    }
}
