package com.capstone.flat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FlatAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "address_id")
	private int AddressId;

	@Column(name = "house_no")
	private String houseNo;

	private String street;
	private String city;
	private String state;
	private int pin;
	private String country;

}

