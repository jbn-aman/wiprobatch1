package com.capstone.tenantmodule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flat {
	
	private int flatId;
	private float cost;
	private FlatAddress flatAddress;
	private String availability;
	private int landlordId;
}
