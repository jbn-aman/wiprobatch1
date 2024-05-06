package com.capstone.flatbooking.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlatAddress {

	    private int addressId;
	    private String houseNo;
	    private String street;
	    private String city;
	    private String state;
	    private int pin;
	    private String country;

}
