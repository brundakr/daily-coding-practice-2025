package org.example.week2.day11.morning;


interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car drive");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Bike drive");
    }
}

class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Truck drive");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Invalid Vehicle type: " + type);
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.createVehicle("car");
        Vehicle vehicle2 = VehicleFactory.createVehicle("bike");
        Vehicle vehicle3 = VehicleFactory.createVehicle("truck");

        vehicle1.drive();
        vehicle2.drive();
        vehicle3.drive();
    }
}
