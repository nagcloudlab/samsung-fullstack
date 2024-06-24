package com.example;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// by default, all primitive types are serializable
// string is also serializable
// if we want to serialize an object, the object must implement Serializable interface

public class Product implements java.io.Externalizable {

    private static final long serialVersionUID = 13242335345345L;
    private String name;
    private double price;
    private transient int quantity;
    private int newField = 0;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }

    @Override
    public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'readExternal'");
    }

    @Override
    public void writeExternal(ObjectOutput arg0) throws IOException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'writeExternal'");
    }

}
