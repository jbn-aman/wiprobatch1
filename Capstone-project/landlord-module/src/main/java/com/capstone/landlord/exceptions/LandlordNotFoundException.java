package com.capstone.landlord.exceptions;

@SuppressWarnings("serial")
public class LandlordNotFoundException extends RuntimeException {
	
	public LandlordNotFoundException() {
		
	}
	
	public LandlordNotFoundException(String msg) {
		super(msg);
	}

}
