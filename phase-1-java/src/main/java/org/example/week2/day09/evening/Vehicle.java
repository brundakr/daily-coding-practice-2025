package org.example.week2.day09.evening;

public abstract class Vehicle implements Drivable {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    abstract int getNoOfWheels();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + model + ")";
    }
}
