package com.example;

import com.example.model.Car;
import com.example.model.Owner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App5 {

    public static void main(String[] args) {

        Owner owner1 = new Owner("John", "address-1");
        Owner owner2 = new Owner("Jane", "address-2");

        Car car1 = new Car("Toyota", "Camry", 2018, "red", 1000.00);
        Car car2 = new Car("BMW", "model", 2019, "red", 1000.00);

        Map<Owner, Car> map = new HashMap<>();
        map.put(owner1, car1);
        map.put(owner2, car2);

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter owner name: ");
        String name = scanner.nextLine();

        Owner key = new Owner(name, null);
        Car car = map.get(key);
        if (car != null) {
            System.out.println("Car: " + car);
        } else {
            System.out.println("Car not found for owner: " + name);
        }

    }

}
