package com.wipro.springcore;

public class Square implements Shape{
	
	private double side;
	
	public void setSide(double side) {
		this.side = side;
	}
	
	@Override
	public double area() {
		System.out.println("Square area ");
		
		double result = side * side;
		return result;
	}

}
