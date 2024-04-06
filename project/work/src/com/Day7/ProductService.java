package com.Day7;

import java.util.LinkedHashSet;

public class ProductService {

	LinkedHashSet<Product> products = new LinkedHashSet<>();

	public boolean addProduct(Product p) {
		return products.add(p);
	}

	public double updatePrice(String productId, double newPrice) {
		for (Product p : products) {
			if (p.getProductId().equals(productId)) {
				p.setPrice(newPrice);
				return newPrice;
			}
		}
		return 0;

	}
}
