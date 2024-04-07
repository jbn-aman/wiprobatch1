package com.wipro.springcore.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springcore.bean.Employee;
import com.wipro.springcore.controller.EmployeeController;
import com.wipro.springcore.dao.EmployeeDao;
import com.wipro.springcore.service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {

		Employee emp1 = new Employee(10, "Aman", "Aman@xyz.com", 90000);

		Employee emp2 = new Employee(20, "Rohit", "Rohit@xyz.com", 97000);

		Employee emp3 = new Employee(30, "John", "John@xyz.com", 95000);
		
		Employee emp4 = new Employee(40, "Joe", "Joe@xyz.com", 88000);

		EmployeeDao eDao = new EmployeeDao();
		EmployeeService eService = new EmployeeService();
		eService.setEmployeeDao(eDao); // dao obj injected inside service

		EmployeeController eController = new EmployeeController();
		eController.setEmployeeService(eService); // service obj injected inside controller

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("empcontext.xml");
		EmployeeController eController1 = (EmployeeController) context.getBean("eController");

		/* ProductController pController = context.getBean(ProductController.class); */

		eController1.addEmployee(emp1);
		eController1.addEmployee(emp2);
		eController1.addEmployee(emp3);
		eController1.addEmployee(emp4);

		eController1.fetchAllEmployees();

		
		eController1.getEmployeeById();

		context.close();

		context.close();

	}
}
