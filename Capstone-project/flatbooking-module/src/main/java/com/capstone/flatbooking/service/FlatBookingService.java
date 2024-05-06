package com.capstone.flatbooking.service;

import java.util.List;

import com.capstone.flatbooking.entity.FlatBooking;

public interface FlatBookingService {

	FlatBooking saveFlatBooking(FlatBooking flatBooking);
    
	FlatBooking getBookingDetails(int bookingId);
    
    List<FlatBooking> getAllBooking();
    
    void deleteBooking(int bookingId);
     
	void acceptBooking(int bookingId);

    void denyBooking(int bookingId);
    
    String viewBookingStatus(int bookingId);
    
    void cancelBooking(int bookingId);
	
}
