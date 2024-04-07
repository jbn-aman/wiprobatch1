package com.wipro.springcore.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wipro.springcore.bean.Employee;
import com.wipro.springcore.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService ;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void addEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		System.out.println("Employee saved!");
	}
	
	public void fetchEmployeeDetails(int empId) {
	
		Employee employee = employeeService.getEmployeeDetails(empId);
		if(employee!=null) {
			System.out.println("Employee Name: "+employee.getEmpName());
					System.out.println("Salary: "+employee.getSalary());
		}
		else {
			System.out.println("Employee not existing with id: " +empId);
		}
	}
	public void fetchAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		employees.forEach(p-> System.out.println(p.getEmpId()+" "+p.getEmpName()+" "+p.getEmail()+" "+p.getSalary()));
	}
	
	public void getEmployeeById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID to find: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        Employee employee = employeeService.getEmployeeDetails(empId);
        
        if (employee != null ) {
            System.out.println("Employee details for ID " + empId + ":");
            System.out.println("Name: " + employee.getEmpName());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Salary: " + employee.getSalary());
        } else {
            System.out.println("Employee not found with ID " + empId);
        }
    }
	

}
