package org.example.week2.day09.evening;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, String model) {
        switch (type.toLowerCase()) {
            case "car": return new Car(model);
            case "truck": return new Truck(model);
            default: throw new IllegalArgumentException(type + "Invalid type");
        }
    }

}
