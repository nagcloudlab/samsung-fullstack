package com.example.observer;

public class Fan implements DoorListener{
        @Override
        public void on(DoorEvent event) {
            System.out.println("Fan on");
        }
        @Override
        public void off(DoorEvent event) {
            System.out.println("Fan off");
        }
}
