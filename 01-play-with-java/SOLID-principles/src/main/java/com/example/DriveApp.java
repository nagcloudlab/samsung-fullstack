package com.example;

import com.example.car.Car;
import com.example.wheel.CEATWheel;
import com.example.wheel.MRFWheel;
import com.example.wheel.Wheel;

public class DriveApp {
    public static void main(String[] args) {

        Wheel mrfWheel=new MRFWheel();
        Wheel ceatWheel=new CEATWheel();

        Car car=new Car(mrfWheel);
        System.out.println("-".repeat(100));
        // trip-1
        car.move();
        System.out.println("-".repeat(100));
        // trip-2
        car.move();
        System.out.println("-".repeat(100));
        // trip-3
        car.setWheel(ceatWheel);
        car.move();

    }
}
