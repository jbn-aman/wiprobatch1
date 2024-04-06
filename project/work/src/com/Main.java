package com;

public class Main {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();

        // Creating a car
        Car car = vehicleService.createCar("Honda", "City", "sedan");
        System.out.println(car.getManufacturerInformation());

        // Creating a bike
        Bike bike = vehicleService.createBike("Bajab", "Pulsar 220", "sports");
        System.out.println(bike.getManufacturerInformation());

        // Comparing max speed of two vehicles
        Car sportsCar1 = new Car("BMW", "Z4", "sports");
        Car sportsCar2 = new Car("AUDI", "R8", "sports");
        System.out.println("Max speed of sports cars: " + vehicleService.compareMaxSpeed(sportsCar1, sportsCar2));

        // Creating a cruiser bike
        Bike cruiserBike = vehicleService.createBike("KEEWAY", "V302C", "cruiser");
        System.out.println(cruiserBike.getManufacturerInformation());
    }
}

