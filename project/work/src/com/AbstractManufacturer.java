package com;

public abstract class AbstractManufacturer {
	private String name;
	private String modelName;
	private String type;
	public AbstractManufacturer(String name, String modelName, String type) {
		super();
		this.name = name;
		this.modelName = modelName;
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public String getModelName() {
		return this.modelName;
	}
	public String getType() {
		return this.type;
	}
	public abstract String getManufacturerInformation();
	
	

}
