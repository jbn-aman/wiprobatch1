package com.abc.mongodbdemo.service;

import java.util.List;

import com.abc.mongodbdemo.entity.Product;

public interface ProductService {
		
		Product saveProduct(Product product);
		
		Product getProductById(int productId);
		
		List<Product> getAllProduct();
		
		Product updateProduct(Product product);
		
		void deleteProduct(int productId);

}
