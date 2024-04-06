package com.wipro.springcore;

public class ShapeService {

	private Shape shape;

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public double findArea() {
		double result = shape.area();
		return result;
	}

}
