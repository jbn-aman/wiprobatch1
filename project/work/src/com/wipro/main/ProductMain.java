package com.wipro.main;

import com.wipro.bean.Product;

public class ProductMain {
	
	Product p1 = new Product();
	p1.setProductId(10);
	p1.setProductName("Iphone");
	p1.setProductPrice(60000);
	
	System.out.println("Product Id is "+p1.getProductId());
	System.out.println("Product Id is "+p1.getProductName());
	System.out.println("Product Id is "+p1.getProductPrice());
}

}
