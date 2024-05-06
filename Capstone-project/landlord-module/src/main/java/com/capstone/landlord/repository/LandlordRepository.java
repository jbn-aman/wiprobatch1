package com.capstone.landlord.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capstone.landlord.entity.Landlord;
import com.capstone.landlord.model.Tenant;

public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
 
	void save(Tenant tenant);
}
