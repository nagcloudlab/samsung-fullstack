package com.example;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class App2 {

    public static void main(String[] args) {

        List<Product> arrayList= new ArrayList<>(100000);
//        arrayList.add(new Product(1,"TV", 1000));
//        arrayList.add(new Product(2,"Mobile", 100));

        List<Product> linkedList= new LinkedList<>();
//        linkedList.add(new Product(1,"TV", 1000));
//        linkedList.add(new Product(2,"Mobile", 100));


        compare(arrayList);
        System.out.println("--------------------");
        compare(linkedList);
        System.out.println("--------------------");
        compare(new Vector<>());



    }

    private static void compare(List<Product> list) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(new Product(i,"Product "+i, i*100));
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken to add elements: "+(end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Time taken to get elements: "+(end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println("Time taken to remove elements: "+(end-start));
    }

}
