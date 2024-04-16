package com.abc.myapp.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.myapp.model.Product;
import com.abc.myapp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public String saveProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return "Product Saved";		
	}
	
	@GetMapping("/{id}")
	public Product getProductDetails(@PathVariable("id") int productId) {
	Product product = productService.getProductById(productId);
	return product;
	}
	
	@GetMapping("/all")
	public List<Product> fetchAllProduct(){
		List<Product> products = productService.getAllProduct();
		return products;
		
	}
	
	
	/*@GetMapping("/details")
	public Product getProductDetails() {
		
		Product product = new Product();
		product.setProductId(100);
		product.setProductName("IPhone X");
		product.setProductPrice(70000);
		
		return product;		
	}
	
	@GetMapping("/all")
	public List<Product> fetchAllProducts() {
		
		Product product1 = new Product();
		product1.setProductId(100);
		product1.setProductName("IPhone X");
		product1.setProductPrice(70000);
		
		Product product2 = new Product();
		product2.setProductId(200);
		product2.setProductName("IPhone Y");
		product2.setProductPrice(80000);
		
		Product product3 = new Product();
		product3.setProductId(300);
		product3.setProductName("IPhone Z");
		product3.setProductPrice(60000);
		
		List<Product> products = new ArrayList<>();
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		return products;
	}*/
}
