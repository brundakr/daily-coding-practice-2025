package org.example.week2.day09.evening;

public class Truck extends Vehicle {

    public Truck(String model) {
        super(model);
    }

    @Override
    public int getNoOfWheels() {
        return 8;
    }

    @Override
    public void drive() {
        System.out.println(getModel() + " driving");
    }

    @Override
    public void stop() {
        System.out.println(getModel() + " stopped");
    }

}
