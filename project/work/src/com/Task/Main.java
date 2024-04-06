package com.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Product p1 = new Product(154, "Iphone X", 70000, "Mobile");
        Product p2 = new Product(209, "Samsung Y", 79999, "Mobile");
        Product p3 = new Product(302, "Pulsar 220", 170000, "Bike");
        Product p4 = new Product(173, "HP Pavilion", 80000, "Laptop");
        Product p5 = new Product(20, "Thar", 1709999,"Car");

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        
     
        ProductServices productService = new ProductServices();
     
        List<String> productNames = productService.mapToProductNames(productList);
        System.out.println("Product Names: " + productNames);

        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter a category name to filter products: ");
			String category = sc.nextLine();

			List<Product> filteredProducts = productService.filterProduct(productList, category);
			System.out.println("Filtered Products in category '" + category + "': ");
			for (Product product : filteredProducts) {
				System.out.println("Product ID: " + product.getProductId());
			    System.out.println("Product Name: " + product.getProductName());
			    System.out.println("Product Price: " + product.getProductPrice());
			    System.out.println("Category: " + product.getCategory());
			    System.out.println();
			}
		}
    }

}