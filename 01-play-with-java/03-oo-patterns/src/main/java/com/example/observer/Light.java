package com.example.observer;

public class Light implements DoorListener{

    @Override
    public void on(DoorEvent event) {
        System.out.println("Light on - " + event.number()+ " - " + event.floor());
    }

    @Override
    public void off(DoorEvent event) {
        System.out.println("Light off - " + event.number()+ " - " + event.floor());
    }
}
