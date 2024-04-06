package com.wipro.springcore.main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springcore.bean.Address;
import com.wipro.springcore.bean.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springcore.xml");
		Employee employee1 = (Employee) context.getBean("emp1");

		System.out.println("Employee Id :" + employee1.getEmpId());
		System.out.println("Employee Name :" + employee1.getName());
		System.out.println("Skills :" + employee1.getSkills());
		
		Address address = employee1.getAddress();
		System.out.println("Address Id " +address.getAddressId());
		System.out.println("Door no. "+address.getDoorNo());
		System.out.println("City: "+address.getCity());
		System.out.println("State: "+address.getState());
		
		context.close();

	}

}
