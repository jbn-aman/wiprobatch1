package com.capstone.landlord.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.landlord.entity.Landlord;
import com.capstone.landlord.exceptions.LandlordNotFoundException;

import com.capstone.landlord.repository.LandlordRepository;

@Service
public class LandlordServiceImpl implements LandlordService {

	@Autowired
	private LandlordRepository landlordRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		landlordRepository.save(landlord);
		return landlord;
	}

	@Override
	public Landlord updateLandlord(Landlord landlord) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlord.getLandlordId());
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id " + landlord.getLandlordId() + " does not exist");
		}
		landlordRepository.save(landlord);
		return landlord;
	}

	@Override
	public Landlord viewLandlord(int landlordId) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id " + landlordId + " does not exist");
		}
		Landlord landlord = optionalLandlord.get();
		return landlord;
	}

	@Override
	public List<Landlord> viewAllLandlords() {
		List<Landlord> landlords = landlordRepository.findAll();
		return landlords;
	}

	@Override
	public void deleteLandlord(int landlordId) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id " + landlordId + " does not exist");
		}
		Landlord landlord = optionalLandlord.get();
		landlordRepository.delete(landlord);

	}
}