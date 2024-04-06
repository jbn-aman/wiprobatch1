package com.Day7;

public class ProductServiceMain {
	
	public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product1 = new Product("P001", "Product 1", 10.99);
        Product product2 = new Product("P002", "Product 2", 20.99);

        productService.addProduct(product1);
        productService.addProduct(product2);

        System.out.println("Price before update:");
        System.out.println("Product 1 price: " + product1.getPrice());
        System.out.println("Product 2 price: " + product2.getPrice());
        
        productService.updatePrice("P001", 15.99);
        productService.updatePrice("P002", 25.99);

        System.out.println("Price after update:");
        System.out.println("Product 1 price: " + product1.getPrice());
        System.out.println("Product 2 price: " + product2.getPrice());
    }

}
