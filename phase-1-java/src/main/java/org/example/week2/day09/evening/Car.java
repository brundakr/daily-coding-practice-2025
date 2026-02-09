package org.example.week2.day09.evening;

public class Car extends Vehicle{

    public Car(String model) {
        super(model);
    }

    @Override
    public int getNoOfWheels() {
        return 4;
    }

    @Override
    public void drive() {
        System.out.println(getModel() + " is driving");
    }

    @Override
    public void stop() {
        System.out.println(getModel() + " stopped");
    }

}
