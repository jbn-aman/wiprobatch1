package com.capstone.flat.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.flat.entity.Flat;
import com.capstone.flat.service.FlatService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/flat")
public class FlatController {
	
	@Autowired
	private FlatService flatService;
	
	@PostMapping("/add")
	public ResponseEntity<Flat> saveFlat(@Valid @RequestBody Flat flat) {
		flatService.addFlat(flat);
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(flat,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Flat> updateFlat(@Valid @RequestBody Flat flat) {
		flatService.updateFlat(flat);
		ResponseEntity<Flat> responseEntity= new ResponseEntity<>(flat, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteFlat(@PathVariable("id")int flatId){
		flatService.deleteFlat(flatId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Flat> getflatDetails(@PathVariable("id") int flatId){
		Flat flat = flatService.viewFlatById(flatId);
		return new ResponseEntity<>(flat,HttpStatus.OK);
	}	
	
	@GetMapping("/all")
	public List<Flat> fetchAllFlats(){
		List<Flat> flats = flatService.viewAllFlats();
		return flats;
	}
	
	@GetMapping("/flatsbycost")
    public List<Flat> viewAllFlatsByCost(@RequestParam(value = "cost", required = false) Float cost,
                                          @RequestParam(value = "availability", required = false) String availability) {
        return flatService.viewAllFlatsByCost(cost, availability);
    }

}
