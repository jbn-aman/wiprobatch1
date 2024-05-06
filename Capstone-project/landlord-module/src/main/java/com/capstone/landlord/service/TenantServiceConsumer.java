package com.capstone.landlord.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.landlord.model.Tenant;

@FeignClient(name = "TENANTMODULE")
public interface TenantServiceConsumer {
	
	@GetMapping("/tenant/viewtenant/{tenantId}")
    Tenant getTenantDetails(@PathVariable("tenantId") int tenantId);	

}
