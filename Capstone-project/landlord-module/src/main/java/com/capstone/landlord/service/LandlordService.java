package com.capstone.landlord.service;

import java.util.List;

import com.capstone.landlord.entity.Landlord;

public interface LandlordService {
	
	Landlord addLandlord(Landlord landlord);

	Landlord updateLandlord(Landlord landlord);

	void deleteLandlord(int landlordId);

	Landlord viewLandlord(int landlordId);

	List<Landlord> viewAllLandlords();
	
}
