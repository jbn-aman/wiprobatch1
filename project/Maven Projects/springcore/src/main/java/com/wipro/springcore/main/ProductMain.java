package com.wipro.springcore.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springcore.bean.Product;

public class ProductMain {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springcore.xml");
		Product product1 = (Product) context.getBean("p1");

		System.out.println("Product Id :" + product1.getProductId());
		System.out.println("Product Name :" + product1.getProductName());
		System.out.println("Product Price :" + product1.getProductPrice());
		
		Product product2 = (Product) context.getBean("p1");
		
		if(product1 == product2) {
			System.out.println("Both Products are same");			
		}
		else {
			System.out.println("Both Products are not same");
		}
		
		context.close();
		
	}
}