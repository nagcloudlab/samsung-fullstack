package com.example;


// Open for extension but closed for modification
public class TeamManager {

//    public void manageJavaEmployee(JavaEmployee javaEmployee) {
//        javaEmployee.doListen();
//        javaEmployee.doProgramming();
//    }
//
//    public void manageJavascriptEmployee(JavascriptEmployee javascriptEmployee) {
//        javascriptEmployee.doListen();
//        javascriptEmployee.doProgramming();
//    }

    // upcasting
    public void manageEmployee(Employee employee) {
        employee.doListen();
        employee.doProgramming();
    }

}
