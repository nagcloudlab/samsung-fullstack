package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerlizationEx {

    public static void main(String[] args) throws Exception {

        Product product = new Product("Laptop", 1000, 2);

        // Serialization
        FileOutputStream fileOutputStream = new FileOutputStream(new File("product.ser"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(product);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("Product object has been serialized");

    }

}
