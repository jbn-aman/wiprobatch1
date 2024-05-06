package com.capstone.tenantmodule.controller;

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


import com.capstone.tenantmodule.entity.Tenant;
import com.capstone.tenantmodule.model.Flat;
import com.capstone.tenantmodule.model.FlatBooking;
import com.capstone.tenantmodule.service.FlatBookingConsumer;
import com.capstone.tenantmodule.service.FlatServiceConsumer;
import com.capstone.tenantmodule.service.TenantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
    private TenantService tenantService;
	
	@Autowired
	private FlatServiceConsumer flatService;
	
	@Autowired
	private FlatBookingConsumer bookingService;

    @PostMapping("/save")
    public ResponseEntity<Tenant> addTenant(@Valid @RequestBody Tenant tenant) {
    	tenantService.addTenant(tenant);
		ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(tenant,HttpStatus.CREATED);
		return responseEntity;
	}
    @PutMapping("/update")
    public ResponseEntity<Tenant> updateTenant(@Valid @RequestBody Tenant tenant) {
    	tenantService.updateTenant(tenant);
		ResponseEntity<Tenant> responseEntity= new ResponseEntity<>(tenant, HttpStatus.OK);
		return responseEntity;
	}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable("id") int tenantId) {
    	tenantService.deleteTenant(tenantId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

    @GetMapping("/viewtenant/{tenantId}")
    public ResponseEntity<Tenant> viewTenant(@PathVariable("tenantId") int tenantId) {
        Tenant tenant= tenantService.viewTenantById(tenantId);
        return new ResponseEntity<>(tenant,HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Tenant> viewAllTenants() {
        List<Tenant> tenants=tenantService.viewAllTenants();
        return tenants;
    }
    @GetMapping("/flat/all")
    public List<Flat> viewAllFlats() {
        List<Flat> flats=flatService.viewAllAvailableFlats();
        return flats;
    }
    
    @PostMapping("/booking/request")
    public ResponseEntity<FlatBooking> addBooking(@RequestBody FlatBooking flatBooking) {
    	bookingService.addBooking(flatBooking);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(flatBooking,HttpStatus.CREATED);
		return responseEntity;
	}
    
    @GetMapping("/booking/status/{id}")
    public String viewBookingStatus(@PathVariable("id") int bookingId) {    	
    	String bookingStatus = bookingService.viewBookingStatus(bookingId);
		return bookingStatus;
    	
    }
    
}