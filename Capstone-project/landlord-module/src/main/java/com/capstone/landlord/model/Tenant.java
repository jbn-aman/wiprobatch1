package com.capstone.landlord.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenant {

	private int tenantId;
	private String tenantName;
	private int tenantAge;

	private TenantAddress tenantAddress;
	
	private String email;
	private String idType;
	private String idNo;
	
}
