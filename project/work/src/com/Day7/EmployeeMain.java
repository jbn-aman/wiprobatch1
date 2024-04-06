package com.Day7;

import java.time.LocalDate;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		
		emp1.setEmpId(101);
		emp1.setEmpName("Aman");
		emp1.setDob(LocalDate.of(2001, 11, 24));
		emp1.setSalary(90000);
		emp1.setRole(Role.Admin);
		
		System.out.println("Employee Details: ");
		
		System.out.println("Employee Id: "+emp1.getEmpId());
		System.out.println("Employee Name: "+emp1.getEmpName());
		System.out.println("Employee Details: "+emp1.getDob());
		System.out.println("Employee Details: "+emp1.getSalary());
		System.out.println("Employee Details: "+emp1.getRole());
		
	
	}

}
