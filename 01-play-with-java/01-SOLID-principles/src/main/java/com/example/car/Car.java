package com.example.car;


import com.example.wheel.Wheel;

public class Car {

    private Wheel wheel;

    public Car(Wheel wheel){
        this.wheel = wheel;
        System.out.println("-- Car object created");
    }

    public void setWheel(Wheel wheel){
        this.wheel = wheel;
    }

    public void move(){
        wheel.rotate();
        System.out.println("Car is moving");
    }

}
