package com.example;

import com.example.bill.Billing;
import com.example.bill.Billing_v1;
import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrixFactory;

public class App {
    public static void main(String[] args) {

        // phase1 : init / bootstrapping
        System.out.println("-".repeat(100));
        // create components
        // dependency components
        PriceMatrix priceMatrixV1= PriceMatrixFactory.getPriceMatrix("1.0");
        //PriceMatrix priceMatrixV2= PriceMatrixFactory.getPriceMatrix("2.0");
        // dependent component
        Billing billingV1 = new Billing_v1(priceMatrixV1);
        System.out.println("-".repeat(100));
        // phase2 : run
        // cart-1
        String[] cart1 = {"apple", "orange", "banana"};
        double total = billingV1.getTotalPrice(cart1);
        System.out.println("Total price: " + total);

        // cart-2
        String[] cart2 = {"apple", "orange"};
        total = billingV1.getTotalPrice(cart2);
        System.out.println("Total price: " + total);


        System.out.println("-".repeat(100));
        // phase3 : shutdown
        // destroy components
        System.out.println("-".repeat(100));

    }
}
