package com.capstone.flatbooking.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tenant {

	private int tenantId;
	private String tenantName;
	private int tenantAge;
    private TenantAddress tenantAddress;
    
	private String email;
	private String idType;
	private String idNo;    

}
