package com.capstone.tenantmodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.tenantmodule.entity.Tenant;
import com.capstone.tenantmodule.exception.TenantNotFoundException;
import com.capstone.tenantmodule.repository.TenantRepository;

@Service
public class TenantServiceImpl implements TenantService {
	@Autowired
	private TenantRepository tenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		tenantRepository.save(tenant);
		return tenant;
	}

	@Override
	public Tenant updateTenant(Tenant tenant) {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenant.getTenantId());
		if (optionalTenant.isEmpty()) {

			throw new TenantNotFoundException("Tenant not existing with id: " + tenant.getTenantId());
		}

		tenantRepository.save(tenant);
		return tenant;
	}

	@Override
	public void deleteTenant(int tenantId) {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if (optionalTenant.isEmpty()) {

			throw new TenantNotFoundException("Tenant not existing with id: " + tenantId);

		}
		Tenant tenant = optionalTenant.get();
		tenantRepository.delete(tenant);
	}

	@Override
	public Tenant viewTenantById(int tenantId) {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if (optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id: " + tenantId);

		}
		Tenant tenant = optionalTenant.get();
		return tenant;
	}

	@Override
	public List<Tenant> viewAllTenants() {
		List<Tenant> tenants = tenantRepository.findAll();
		return tenants;
	}

}