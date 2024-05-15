package com.example.proxy;

public class App {

    public static void main(String[] args) {
        Training trainingProxy = new TrainingProxy();
        System.out.println(trainingProxy.getJavaTraining());
        System.out.println(trainingProxy.getJavascriptTraining());
    }

}
