package com.capstone.landlord.controller;

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

import com.capstone.landlord.entity.Landlord;
import com.capstone.landlord.model.Flat;
import com.capstone.landlord.model.FlatBooking;
import com.capstone.landlord.model.Tenant;
import com.capstone.landlord.service.FlatBookingConsumer;
import com.capstone.landlord.service.FlatServiceConsumer;
import com.capstone.landlord.service.LandlordService;
import com.capstone.landlord.service.TenantServiceConsumer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/landlord")
public class LandlordController {
	
	@Autowired
	private LandlordService landlordService;
	
	@Autowired
	private TenantServiceConsumer tenantService;
	
	@Autowired
	private FlatServiceConsumer flatService;
	
	@Autowired
	private FlatBookingConsumer bookingService;	
	
	@GetMapping("/all")
	public List<Landlord> getAllLandlords() {
		List<Landlord> landlords = landlordService.viewAllLandlords();
		return landlords;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Landlord> fetchLandlordDetails(@PathVariable("id") int landlordId) {
		Landlord landlord = landlordService.viewLandlord(landlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<Landlord> addLandlord(@Valid @RequestBody Landlord landlord) {
		landlordService.addLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(landlord, HttpStatus.CREATED);
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Landlord> updateLandlord(@Valid @RequestBody Landlord landlord) {
		landlordService.updateLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(landlord, HttpStatus.OK);
		return responseEntity;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLandlord(@PathVariable("id") int landlordId) {
		landlordService.deleteLandlord(landlordId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/flat/add")
	public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {
		flatService.addFlat(flat);
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(flat, HttpStatus.CREATED);
		return responseEntity;
	}
	@DeleteMapping("/flat/delete/{id}")
	public ResponseEntity<Void> deleteFlat(@PathVariable("id") int flatId) {
		flatService.deleteFlat(flatId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/flat/all")
	public List<Flat> viewAllFlats() {
		List<Flat> flats = flatService.viewAllFlats();
		return flats;
	}
	
	@GetMapping("/tenant/viewtenant/{tenantId}")
	public ResponseEntity<Tenant> viewTenantById(@PathVariable("tenantId") int tenantId) {
		Tenant tenant = tenantService.getTenantDetails(tenantId);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}
	
	@PostMapping("/booking/accept/{id}")
	public ResponseEntity<FlatBooking> acceptBooking(@PathVariable("id") int bookingId) {
		bookingService.acceptBooking(bookingId);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/booking/deny/{id}")
	public ResponseEntity<FlatBooking> denyBooking(@PathVariable("id") int bookingId) {
		bookingService.denyBooking(bookingId);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
}
