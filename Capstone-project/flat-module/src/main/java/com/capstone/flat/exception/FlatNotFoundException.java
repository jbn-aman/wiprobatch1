package com.capstone.flat.exception;

@SuppressWarnings("serial")
public class FlatNotFoundException extends RuntimeException {
	
	public FlatNotFoundException() {
		
	}
	
	public FlatNotFoundException(String msg) {
		super(msg);
	}

}

