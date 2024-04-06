package com.Day7;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {
	
	public static void main (String[] args) {
		
		Optional<String> emptyOptional = Optional.empty();
		
		if(emptyOptional.isEmpty()) {
			System.out.println("empty Optional");
		
		}
		
		String name = "John";
		Optional <String> nonEmptyOptional= Optional.of(name);
		
		if(nonEmptyOptional.isPresent()) {
			
			String str = nonEmptyOptional.get();
			System.out.println("Value: "+str);
			
		}
		
		Integer[] ary = {10,20,30,40};
		
		Optional<Integer> optionalobj = Arrays.stream(ary).reduce((a,b)->a+b);
		
		if(optionalobj.isPresent()) {
			
			int sum = optionalobj.get();
			System.out.println("Sum "+sum);
		}
			
		}

	
	

}
