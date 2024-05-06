package com.capstone.flatbooking.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.flatbooking.model.Flat;

@FeignClient(name="FLATMODULE")
public interface FlatServiceConsumer {
	
	@GetMapping("/flat/{id}")
	Flat getFlatById(@PathVariable("id") int flatNo);	
	
}
