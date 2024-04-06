package com.wipro.springcore;

public class HelloBean {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void display() {
		System.out.println("Message sent: " + message);
	}
}
