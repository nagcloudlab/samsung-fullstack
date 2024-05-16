package com.example;


import com.example.container.WebContainer;

public class App1 {
    public static void main(String[] args) {
        WebContainer webContainer = new WebContainer();
        webContainer.handleHttpRequest("/profile");
    }
}
