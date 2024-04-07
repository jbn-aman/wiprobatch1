package com.wipro.springcore.bean;

public class Employee {
	
	private int empId;
	private String empName;
	private String email;
	private double salary;
		
	public Employee(int empId, String empName, String email, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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
	
	
	
	
