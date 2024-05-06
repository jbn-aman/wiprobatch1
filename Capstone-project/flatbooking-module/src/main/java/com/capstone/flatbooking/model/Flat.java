package com.capstone.flatbooking.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Flat {
	
	private int flatId;
	private float cost;
	private FlatAddress flatAddress;
	private String availability;
	private int landlordId;
}
