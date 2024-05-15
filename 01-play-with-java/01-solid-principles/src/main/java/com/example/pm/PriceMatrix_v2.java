package com.example.pm;

public class PriceMatrix_v2 implements PriceMatrix{

    public PriceMatrix_v2() {
        System.out.println("-- PriceMatrix_v2 instance created..");
    }

    public double getPrice(String itemCode) {
        // code to connect to other service and fetch price of the itemCode
        // return price
        return 100.00;
    }

}
