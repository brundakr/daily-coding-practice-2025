package org.example.week2.day09.evening;

public class VehicleManagement {
    public static void main(String[] args) {

        Vehicle car1 = VehicleFactory.createVehicle("car", "Kia Sonet");
        Vehicle car2 = VehicleFactory.createVehicle("car", "MB S-class");
        Vehicle truck1 = VehicleFactory.createVehicle("truck", "Volvo");

        Drivable[] vehicles = {car1, car2, truck1};
        for(Drivable vehicle: vehicles) {
            vehicle.drive();
            vehicle.stop();
            System.out.println(vehicle);
        }

    }
}
