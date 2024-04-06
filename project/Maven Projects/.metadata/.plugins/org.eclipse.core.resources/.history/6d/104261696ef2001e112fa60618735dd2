package com.wipro.springcore2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springcore2.bean.Product;
import com.wipro.springcore2.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao; 
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void saveProduct(Product product) {		
		productDao.addProduct(product);
	}	
	
	public Product getProductDetails(int productId) {		
		Product product = productDao.findProductById(productId);
		return product;
	}
	
	public List<Product> getAllProducts() {		
		List<Product> products = productDao.findAllProducts();
		return products;
	}
}