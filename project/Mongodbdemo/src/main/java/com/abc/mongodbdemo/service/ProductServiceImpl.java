package com.abc.mongodbdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.mongodbdemo.entity.Product;
import com.abc.mongodbdemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public Product getProductById(int productId) {

		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isEmpty()) {
			return null;
		}
		Product product = optionalProduct.get();
		return product;

	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if (optionalProduct.isEmpty()) {
			return null;
		}
		productRepository.save(product);
		return product;
	}

	@Override
	public void deleteProduct(int productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isEmpty()) {

		}
		Product product = optionalProduct.get();
		productRepository.delete(product);

	}
}
