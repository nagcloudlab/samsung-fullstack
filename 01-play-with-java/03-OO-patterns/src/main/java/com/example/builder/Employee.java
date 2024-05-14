package com.example.builder;


class Employee {

    private final int id;
    private final String name;
    private final double salary;
    private final String dept;
    private final String desg;

    private Employee(int id, String name, double salary, String dept, String desg) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
        this.desg = desg;
    }

    public static class Builder {

        private int id;
        private String name;
        private double salary;
        private String dept;
        private String desg;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder dept(String dept) {
            this.dept = dept;
            return this;
        }

        public Builder desg(String desg) {
            this.desg = desg;
            return this;
        }

        public Employee build() {
            return new Employee(id, name, salary, dept, desg);
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                ", desg='" + desg + '\'' +
                '}';
    }
}