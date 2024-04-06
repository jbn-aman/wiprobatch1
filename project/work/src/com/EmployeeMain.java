package com;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Aman","yadav",101,"aman@xyz.com",70000);
		
		System.out.println("Employye Id: "+emp1.getEmpId());
		System.out.println("First Name: "+emp1.getFirstName());
		System.out.println("Last Name: "+emp1.getLastName());
		System.out.println("Email: "+emp1.getEmail());
		System.out.println("Salary "+emp1.getSalary());

	}

}
