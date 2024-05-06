package com.capstone.tenantmodule.service;

import java.util.List;

import com.capstone.tenantmodule.entity.Tenant;

public interface TenantService {
	
	Tenant addTenant(Tenant tenant);

	Tenant updateTenant(Tenant tenant);

	void deleteTenant(int tenantId);

	Tenant viewTenantById(int tenantId);

	List<Tenant> viewAllTenants();
	
}
