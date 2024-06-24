package com.example.model;

public class Owner {
    private String name;
    private String address;

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Owner [name=" + name + ", address=" + address + "]";
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    public  boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Owner owner = (Owner) obj;
        return name.equals(owner.name);
    }

}
