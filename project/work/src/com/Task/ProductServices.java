package com.Task;

import java.util.ArrayList;
import java.util.List;

public class ProductServices {
	
	public List<String> mapToProductNames(List<Product> products) {
        if (products == null || products.isEmpty())
            return null;

        List<String> productNames = new ArrayList<>();
        for (Product product : products) {
            productNames.add(product.getProductName());
        }
        return productNames;
    }

	public List<Product> filterProduct(List<Product> products, String categoryName) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            String productCategory = product.getCategory();            
            if (productCategory != null && productCategory.equals(categoryName)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

}