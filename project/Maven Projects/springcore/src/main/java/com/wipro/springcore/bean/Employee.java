package com.wipro.springcore.bean;

import java.util.Set;

public class Employee {
	
	private int empId;
	private String name;
	private Set<String> Skills;
	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getSkills() {
		return Skills;
	}
	public void setSkills(Set<String> skills) {
		Skills = skills;
	}
	

}
