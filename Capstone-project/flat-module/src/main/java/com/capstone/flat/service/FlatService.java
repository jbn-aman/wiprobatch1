package com.capstone.flat.service;

import java.util.List;

import com.capstone.flat.entity.Flat;

public interface FlatService {

	Flat addFlat(Flat flat);

	Flat updateFlat(Flat flat);

	void deleteFlat(int flatId);

	Flat viewFlatById(int flatId);

	List<Flat> viewAllFlats();

	List<Flat> viewAllFlatsByCost(float cost, String availability);
	
}

