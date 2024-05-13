package com.example.bill;

import com.example.pm.PriceMatrix;

public class Billing_v1 {

    private PriceMatrix priceMatrix; // dependency

    public Billing_v1(PriceMatrix priceMatrix) {
        this.priceMatrix = priceMatrix;
        System.out.println("-- BillingImpl instance created..");
    }

   public double getTotalPrice(String[] cart) {
        double total = 0.0;
        for (String itemCode : cart) {
            total += priceMatrix.getPrice(itemCode);
        }
        return total;
    }

}
