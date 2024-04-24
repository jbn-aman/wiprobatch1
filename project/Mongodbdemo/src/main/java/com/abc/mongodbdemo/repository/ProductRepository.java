package com.abc.mongodbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abc.mongodbdemo.entity.Product;

public interface ProductRepository extends MongoRepository<Product,Integer> {

}
