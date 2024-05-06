package com.capstone.flatbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.capstone.flatbooking.entity.FlatBooking;
import com.capstone.flatbooking.exception.BookingNotFoundException;

import com.capstone.flatbooking.repository.FlatBookingRepository;

@Service
public class FlatBookingServiceImpl implements FlatBookingService {

    @Autowired
    private FlatBookingRepository flatBookingRepository;

    @Override
    public FlatBooking saveFlatBooking(FlatBooking flatBooking) {
    	
        flatBooking.setBookingDate(LocalDate.now());
        flatBooking.setBookingStatus("pending");
        flatBooking.setBookingFromDate(LocalDate.of(2024, 05, 06));
        flatBooking.setBookingToDate(LocalDate.of(2025, 05, 06));

        flatBookingRepository.save(flatBooking);
        return flatBooking;
    }

    @Override
    public FlatBooking getBookingDetails(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new BookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }

        FlatBooking fbooking = optionalBooking.get();
        return fbooking;
    }

    @Override
    public List<FlatBooking> getAllBooking() {
        List<FlatBooking> fBookingList = flatBookingRepository.findAll();
        return fBookingList;
    }

    @Override
    public void deleteBooking(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new BookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBookingRepository.delete(flatBooking);
    }
    
    @Override
    public void acceptBooking(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new BookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBooking.setBookingStatus("accepted");
        flatBookingRepository.save(flatBooking);
    }

    @Override
    public void denyBooking(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new BookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBooking.setBookingStatus("denied");
        flatBookingRepository.save(flatBooking);
        
    } 

	@Override
	public String viewBookingStatus(int bookingId) {
		 Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
		    if (optionalBooking.isEmpty()) {
		        throw new BookingNotFoundException("Flat booking does not exist with id" + bookingId);
		    }
		    FlatBooking flatBooking = optionalBooking.get();
		    return flatBooking.getBookingStatus();
	}
	
	@Override
	public void cancelBooking(int bookingId) {
	    Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
	    if (optionalBooking.isEmpty()) {
	        throw new BookingNotFoundException("Flat booking does not exist with id" + bookingId);
	    }
	    FlatBooking flatBooking = optionalBooking.get();
	    if ("pending".equals(flatBooking.getBookingStatus()) || "accepted".equals(flatBooking.getBookingStatus())) {
	        flatBooking.setBookingStatus("cancelled");
	        flatBookingRepository.save(flatBooking);
	    } 
	}

}