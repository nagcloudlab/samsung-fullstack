package com.example.observer;

import java.util.ArrayList;
import java.util.List;

// Open Closed Principle
public class Door {

    private List<DoorListener> listeners = new ArrayList<>();

    public void addListener(DoorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(DoorListener listener) {
        listeners.remove(listener);
    }

    public void open() {
        System.out.println("Door is open");
        for (DoorListener listener : listeners) {
            listener.on(new DoorEvent(402, 4));
        }
    }

    public void close() {
        System.out.println("Door is closed");
        for (DoorListener listener : listeners) {
            listener.off(new DoorEvent(402, 4));
        }
    }
}
