package com;

public class VehicleService {
	public Car createCar(String name, String modelName, String type) {
        return new Car(name, modelName, type);
    }

    public Bike createBike(String name, String modelName, String type) {
        return new Bike(name, modelName, type);
    }

    public int compareMaxSpeed(Vehicle first, Vehicle second) {
        if ("SPORTS".equalsIgnoreCase(((AbstractManufacturer) first).getType()) &&
        		"SPORTS".equalsIgnoreCase(((AbstractManufacturer) second).getType())) {
            return Math.max(first.maxSpeed(((AbstractManufacturer) first).getType()), 
            		second.maxSpeed(((AbstractManufacturer) second).getType()));
        }
        return -1;
    }
}


