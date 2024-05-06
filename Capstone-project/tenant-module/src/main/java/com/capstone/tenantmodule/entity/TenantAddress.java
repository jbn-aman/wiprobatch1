package com.capstone.tenantmodule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tenantaddress_tbl")
public class TenantAddress {
    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="address_id")
    private int id;
	
	@Column(name="house_no")
	private int houseNo;
    private String street;
    private String city;
    private String state;
    private int pin;
    private String country;	
    
}