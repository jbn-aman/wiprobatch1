package com.capstone.landlord.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capstone.landlord.model.FlatBooking;

@FeignClient(name = "FLATBOOKING-MODULE")
public interface FlatBookingConsumer {
    
    @PostMapping("/booking/accept/{id}")
    FlatBooking acceptBooking(@PathVariable("id") int bookingId);
    
    @PostMapping("/booking/deny/{id}")
    FlatBooking denyBooking(@PathVariable("id") int bookingId);
    
}
