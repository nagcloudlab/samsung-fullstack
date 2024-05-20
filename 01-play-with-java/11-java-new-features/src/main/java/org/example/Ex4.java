package org.example;

import java.util.Optional;


// Ex without Optional

//class Insurance{
//    private String name;
//    private int duration;
//
//    public Insurance(String name, int duration) {
//        this.name = name;
//        this.duration = duration;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//}
//class Car{
//    private String brand;
//    private Insurance insurance;
//
//    public Car(String brand, Insurance insurance) {
//        this.brand = brand;
//        this.insurance = insurance;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public Insurance getInsurance() {
//        return insurance;
//    }
//}
//class Person{
//    private String name;
//    private Car car;
//
//    public Person(String name, Car car) {
//        this.name = name;
//        this.car = car;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Car getCar() {
//        return car;
//    }
//}

// Ex with Optional

class Insurance{
    private String name;
    private int duration;

    public Insurance(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
class Car{
    private String brand;
    private Optional<Insurance> insurance=Optional.empty();

    public Car(String brand, Insurance insurance) {
        this.brand = brand;
        this.insurance = Optional.ofNullable(insurance);
    }

    public String getBrand() {
        return brand;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }


}
class Person{
    private String name;
    private Optional<Car> car=Optional.empty();

    public Person(String name, Car car) {
        this.name = name;
        this.car = Optional.ofNullable(car);
    }

    public String getName() {
        return name;
    }

    public Optional<Car> getCar() {
        return car;
    }
}

public class Ex4 {

    public static void main(String[] args) {

//        Insurance insurance = new Insurance("Allianz", 2);
//        Car car = new Car("Audi", insurance);
//        Person person = new Person("John", car);
//
//        System.out.println(person.getName());
//        System.out.println(person.getCar().getBrand());
//        System.out.println(person.getCar().getInsurance().getName());
//        System.out.println(person.getCar().getInsurance().getDuration());

//        Person person1=new Person("Nag",null);
//        System.out.println(person1.getName());
//        System.out.println(person1.getCar().getBrand());
//        System.out.println(person1.getCar().getInsurance().getName());
//        System.out.println(person1.getCar().getInsurance().getDuration());


        //---------------------------

        Insurance insurance = new Insurance("Allianz", 2);
        Car car = new Car("Audi", insurance);
        Person person = new Person("John", car);

        System.out.println(person.getName());
        System.out.println(person.getCar().map(Car::getBrand).orElse("No Car"));
        System.out.println(person.getCar().flatMap(Car::getInsurance).map(Insurance::getName).orElse("No Insurance"));

        Person person1=new Person("Nag",null);
        System.out.println(person1.getName());
        System.out.println(person1.getCar().map(Car::getBrand).orElse("No Car"));
        System.out.println(person1.getCar().flatMap(Car::getInsurance).map(Insurance::getName).orElse("No Insurance"));

//        ---------------------------

        if(person.getCar().isPresent()) {
            System.out.println(person.getCar().get().getBrand());
        }

    }
}
