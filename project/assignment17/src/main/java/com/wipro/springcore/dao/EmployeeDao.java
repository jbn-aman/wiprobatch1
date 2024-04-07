package com.wipro.springcore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.wipro.springcore.bean.Employee;

@Repository
public class EmployeeDao {

		private List<Employee> employees = new ArrayList<>();

		public void addEmployee(Employee employee) {
			employees.add(employee);
		}

		public Employee findEmployeeById(int empId) {
			Optional<Employee> optionalEmployee = employees.stream().filter(p -> p.getEmpId() == empId).findAny();
			return optionalEmployee.get();
		}

		public List<Employee> findAllEmployees() {
			return employees;
		}

		
	}



