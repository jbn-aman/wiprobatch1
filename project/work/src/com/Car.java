package com;

public class Car extends AbstractManufacturer implements Vehicle{

	public Car(String name,String modelName,String carType) {
		super(name,modelName,carType);
	}
	public int maxSpeed(String carType) {
		if("sports".equalsIgnoreCase(carType)) {
			return 250;
		}else if("seden".equalsIgnoreCase(carType)) {
			return 190;
		}
		return 0;
	}

	@Override
	public String getManufacturerInformation() {
		// TODO Auto-generated method stub
		return "Car{Manufacturer name:'" + getName() + "',Model Name:'" + getModelName() + "',Type:'" + getType() + "}";
	}
}
