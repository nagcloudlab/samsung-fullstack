package com.example;

import com.example.model.Product;
import com.example.util.LinkedList;

import java.util.Iterator;

public class App {

    public static void main(String[] args) {

        LinkedList<String> friendNames = new LinkedList<>();
        friendNames.add("John");
        friendNames.add("Doe");

        LinkedList<Product> products = new LinkedList<>();
        products.add(new Product(1,"TV", 1000));
        products.add(new Product(2,"Mobile", 100));
        products.add(new Product(3,"Laptop", 500));
        products.add(0,new Product(4,"Tab", 500));

//
//        Product product= products.get(0);
//        System.out.println(product);


        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product);
        }

        // or

        for (Product product : products) {
            System.out.println(product);
        }


    }

}
