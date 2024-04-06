package com.Day7;

import java.time.LocalDate;

public class ProductMain1 {
	
	public static void main(String[] args) {
		
		Product1 product1 = new Product1();
		
		product1.setProductId(101);
		product1.setProductName("Iphone Y");
		product1.setProductPrice(70000);
		product1.setMfd(LocalDate.of(2024, 01,20));
		product1.setCategory("Mobile");
		
		System.out.println("Product Details");
		System.out.println("ID: "+product1.getProductId());
		System.out.println("Name: "+product1.getProductName());
		System.out.println("Price: "+product1.getProductPrice());
		System.out.println("MFD: "+product1.getMfd());
		System.out.println("Category: "+product1.getCategory());
		
		Product1 product2 = new Product1(102,"Iphone Z",80000,LocalDate.of(2024, 03, 20),"Mobile");
		
		System.out.println("Product Details");
		System.out.println("ID: "+product2.getProductId());
		System.out.println("Name: "+product2.getProductName());
		System.out.println("Price: "+product2.getProductPrice());
		System.out.println("MFD: "+product2.getMfd());
		System.out.println("Category: "+product2.getCategory());
		
		
		
	}

}
