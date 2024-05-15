package com.example.observer;

public class Ac implements DoorListener
{
    @Override
    public void on(DoorEvent event) {
        System.out.println("AC on");
    }

    @Override
    public void off(DoorEvent event) {
        System.out.println("AC off");
    }
}
