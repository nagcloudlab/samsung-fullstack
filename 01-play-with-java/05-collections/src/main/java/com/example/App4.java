package com.example;

import com.example.model.Car;

import java.util.HashSet;
import java.util.Set;

public class App4 {
    public static void main(String[] args) {

        Car car1 = new Car("Ford", "Fiesta", 2010, "red", 10000.0);
        Car car2 = new Car("Ford", "Fiesta", 2010, "red", 10000.0);

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());

        System.out.println(car1.equals(car2));

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);

        System.out.println(cars.size());


    }
}
