package com.example;

public class App {

    public static void main(String[] args) {

        Employee.tnrName = "Nag";

        JavaEmployee javaEmployee = new JavaEmployee(1, "Nag", 1000, "java");
        JavascriptEmployee javascriptEmployee = new JavascriptEmployee(2, "Kishore", 2000, "js");
        PythonEmployee pythonEmployee = new PythonEmployee(3, "Suresh", 3000, "python");

        TeamManager teamManager = new TeamManager();
        //teamManager.manageJavaEmployee(javaEmployee);
        //teamManager.manageJavascriptEmployee(javascriptEmployee);

        teamManager.manageEmployee(javaEmployee);
        teamManager.manageEmployee(javascriptEmployee);


    }

}
