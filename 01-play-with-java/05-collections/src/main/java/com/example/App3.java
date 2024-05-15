package com.example;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App3 {
    public static void main(String[] args) {


        List<Product> products = new ArrayList<>();
        products.add(new Product(2, "Product 2", 200));
        products.add(new Product(1, "Product 1", 100));
        products.add(new Product(4, "Product 4", 400));
        products.add(new Product(3, "Product 3", 300));


        // sorting is 2-step process
        // step-1 : compare
        // step-2 : swap

        // sort the products based on id ( default property )

        Collections.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println();

        // sort the products based on price
        Collections.sort(products, new ProductPriceComparator());
        for (Product product : products) {
            System.out.println(product);
        }

        // or using anonymous inner class
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        for (Product product : products) {
            System.out.println(product);
        }

        // or using lambda expression
        Collections.sort(products, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
        for (Product product : products) {
            System.out.println(product);
        }


    }
}


class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
