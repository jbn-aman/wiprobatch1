package com.capstone.flat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.flat.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat,Integer>{

	List<Flat> findByCostAndAvailability(float cost, String availability);

}


