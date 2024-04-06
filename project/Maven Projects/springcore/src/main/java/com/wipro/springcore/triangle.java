package com.wipro.springcore;

public class triangle implements Shape {
	
	public double base;
	public double height;
	
	

	public void setBase(double base) {
		this.base = base;
	}

	public void setHeight(double height) {
		this.height = height;
	}



	@Override
	public double area() {
		System.out.println("triangle area ");
		double result = 0.5 * base * height;
		return result;
		
	}
}
