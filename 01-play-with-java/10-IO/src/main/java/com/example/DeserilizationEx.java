package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserilizationEx {

    public static void main(String[] args) throws Exception {

        // Deserialization
        FileInputStream fileInputStream = new FileInputStream(new File("product.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Product product = (Product) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println("Product object has been deserialized");
        System.out.println(product);

    }

}
