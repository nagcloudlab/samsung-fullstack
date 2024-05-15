package com.example.pm;

public class PriceMatrix_v1 implements PriceMatrix {

    public PriceMatrix_v1() {
        System.out.println("-- PriceMatrix_v1 instance created..");
    }

    public double getPrice(String itemCode) {
        // code to connect to DB and fetch price of the itemCode
        // select price from item where itemCode=?
        // return price
        return 100.00;
    }

}
