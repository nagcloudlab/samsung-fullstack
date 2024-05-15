package com.example.observer;

// dto = data transfer object
// This is a simple class that is used to transfer data from one place to another.
// It is a simple class that has attributes, getters and setters.
// It is used to transfer data between software application subsystems.

//public class DoorEvent {
//
//    private int number;
//    private int floor;
//
//    public DoorEvent(int number, int floor) {
//        this.number = number;
//        this.floor = floor;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public int getFloor() {
//        return floor;
//    }
//}


// A record is a special kind of class that is introduced in Java 14.
// It is a simple way to create a class that is a simple data carrier.
// It is a class that has attributes, getters and setters.
// It is used to transfer data between software application subsystems.

public record DoorEvent(int number, int floor) {
}
