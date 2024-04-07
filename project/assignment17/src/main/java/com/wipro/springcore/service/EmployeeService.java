package com.wipro.springcore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springcore.bean.Employee;
import com.wipro.springcore.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void saveEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	public Employee getEmployeeDetails(int empId) {
		Employee employee = employeeDao.findEmployeeById(empId);
		return employee;
	}
	
	public List<Employee> getAllEmployees() {		
		List<Employee> employees = employeeDao.findAllEmployees();
		return employees;
	}
}
