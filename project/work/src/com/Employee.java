package com;

public class Employee extends Person {
	private int empId;
	private String email;
	private double salary;
	public Employee(String firstName, String lastName, int empId, String email, double salary) {
		super(firstName, lastName);
		this.empId = empId;
		this.email = email;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}