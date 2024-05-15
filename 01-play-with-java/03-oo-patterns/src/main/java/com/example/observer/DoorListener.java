package com.example.observer;

public interface DoorListener {
    public void on(DoorEvent event);
    public void off(DoorEvent event);
}
