package com.capstone.flatbooking.exception;

@SuppressWarnings("serial")
public class BookingNotFoundException extends RuntimeException {
	
	public BookingNotFoundException() {
		
	}
	
	public BookingNotFoundException(String msg) {
		super(msg);
	}

}
