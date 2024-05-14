package com.example.observer;

import java.util.concurrent.TimeUnit;

public class App1 {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        Light light = new Light();
        Fan fan = new Fan();

        door.addListener(light);
//        door.addListener(fan);

//        door.removeListener(fan);
//        door.addListener(new Ac());

        door.open();
        TimeUnit.SECONDS.sleep(1);
        door.close();

    }
}
