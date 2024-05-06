package com.capstone.tenantmodule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatAddress {

	    private int addressId;
	    private String houseNo;
	    private String street;
	    private String city;
	    private String state;
	    private int pin;
	    private String country;
		
}
