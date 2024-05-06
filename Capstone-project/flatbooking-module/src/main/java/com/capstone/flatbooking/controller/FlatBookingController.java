package com.capstone.flatbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.flatbooking.entity.FlatBooking;
import com.capstone.flatbooking.model.Flat;
import com.capstone.flatbooking.model.Tenant;
import com.capstone.flatbooking.service.FlatBookingService;
import com.capstone.flatbooking.service.FlatServiceConsumer;
import com.capstone.flatbooking.service.TenantServiceConsumer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class FlatBookingController {

	@Autowired
	private FlatBookingService bookingService;

	@Autowired
	private FlatServiceConsumer flatService;

	@Autowired
	private TenantServiceConsumer tenantService;

	@PostMapping("/request")
	public ResponseEntity<FlatBooking> requestflatBooking(@Valid @RequestBody FlatBooking flatBooking) {

		FlatBooking newFBooking = bookingService.saveFlatBooking(flatBooking);
		return new ResponseEntity<>(newFBooking, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlatBooking> fetchBookingDetails(@PathVariable("id") int bookingId) {
		FlatBooking fbooking = bookingService.getBookingDetails(bookingId);
		return new ResponseEntity<>(fbooking, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<FlatBooking> getAllBookings() {

		List<FlatBooking> fBookingList = bookingService.getAllBooking();
		return fBookingList;
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Void> deleteBooking(@PathVariable("id") int bookingId) {
		bookingService.deleteBooking(bookingId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/accept/{id}")
	public ResponseEntity<Void> acceptBooking(@PathVariable("id") int bookingId) {
		bookingService.acceptBooking(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/deny/{id}")
	public ResponseEntity<Void> denyBooking(@PathVariable("id") int bookingId) {
		bookingService.denyBooking(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/flat/{id}")
	public ResponseEntity<Flat> getFlatDetails(@PathVariable("id") int flatId) {
		Flat flat = flatService.getFlatById(flatId);
		return new ResponseEntity<>(flat, HttpStatus.OK);
	}

	@GetMapping("/viewtenant/{tenantId}")
	public ResponseEntity<Tenant> getTenantDetails(@PathVariable("tenantId") int tenantId) {
		Tenant tenant = tenantService.getTenantDetails(tenantId);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}

	@GetMapping("/status/{id}")
	public ResponseEntity<String> viewBookingStatus(@PathVariable("id") int bookingId) {
		String bookingStatus = bookingService.viewBookingStatus(bookingId);
		return new ResponseEntity<>(bookingStatus, HttpStatus.OK);
	}

	@PutMapping("/cancel/{id}")
	public ResponseEntity<Void> cancelBooking(@PathVariable("id") int bookingId) {
		bookingService.cancelBooking(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
