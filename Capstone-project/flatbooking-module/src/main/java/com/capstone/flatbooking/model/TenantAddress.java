package com.capstone.flatbooking.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TenantAddress {

	    private int id;
	    private int houseNo;
	    private String street;
	    private String city;
	    private String state;
	    private int pin;
	    private String country;
		
}
