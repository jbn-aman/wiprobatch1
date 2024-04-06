package com;

public class Bike extends AbstractManufacturer implements Vehicle {
    public Bike(String name, String modelName, String bikeType) {
        super(name, modelName, bikeType);
    }

    @Override
    public int maxSpeed(String bikeType) {
        if ("sports".equalsIgnoreCase(bikeType)) {
            return 300;
        } else if ("cruiser".equalsIgnoreCase(bikeType)) {
            return 170;
        }
        return 0;
    }

    @Override
    public String getManufacturerInformation() {
        return "Bike{Manufacturer name:'" + getName() + "',Model Name:'" + getModelName() + "',Type:'" + getType() + "'}";
    }
}
