package com.capstone.tenantmodule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.tenantmodule.entity.Tenant;
import com.capstone.tenantmodule.entity.TenantAddress;
import com.capstone.tenantmodule.exception.TenantNotFoundException;
import com.capstone.tenantmodule.repository.TenantRepository;
import com.capstone.tenantmodule.service.TenantServiceImpl;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class TenantmoduleApplicationTests {
	
	@InjectMocks
	private TenantServiceImpl tenantService;
	
	@Mock
	private TenantRepository tenantRepository;
	
	@Test
	public void testAddTenant() {
		Tenant tenant = new Tenant();
		TenantAddress tenantAddress = new TenantAddress();
		tenant.setTenantId(1);
		tenant.setTenantName("Aman");
		tenant.setTenantAge(22);
		tenant.setEmail("aman@xyz.com");
		tenant.setIdType("Aadhar");
		tenant.setIdNo("12345678XXX");
		tenantAddress.setId(1);
		tenantAddress.setHouseNo(20);
		tenantAddress.setCity("Ranchi");
		tenantAddress.setCountry("India");
		tenantAddress.setPin(987654);
		tenantAddress.setState("Jharkhand");
		tenantAddress.setStreet("Hec");
		

		when(tenantRepository.save(tenant)).thenReturn(tenant);

		Tenant savedTenant = tenantService.addTenant(tenant);
		
		verify(tenantRepository, times(1)).save(tenant);
		 assertEquals(tenant, savedTenant);
		 assertEquals("Aman", savedTenant.getTenantName());
		 assertEquals(22, savedTenant.getTenantAge());
	}

	@Test
	public void testViewTenantById() {
		
		Tenant tenant=new Tenant();
		TenantAddress tenantAddress = new TenantAddress();
		tenant.setTenantId(1);
		tenant.setTenantName("Aman");
		tenant.setTenantAge(22);
		tenant.setEmail("aman@xyz.com");
		tenant.setIdType("Aadhar");
		tenant.setIdNo("12345678XXX");
		tenantAddress.setId(1);
		tenantAddress.setHouseNo(20);
		tenantAddress.setCity("Ranchi");
		tenantAddress.setCountry("India");
		tenantAddress.setPin(987654);
		tenantAddress.setState("Jharkhand");
		tenantAddress.setStreet("Hec");
		
		when(tenantRepository.findById(1)).thenReturn(Optional.of(tenant));
		Tenant actualObj=tenantService.viewTenantById(1);
		assertEquals(22,actualObj.getTenantAge());
	}
	
	@Test
	public void testViewAllTenants() {
		
		Tenant tenant=new Tenant();
		TenantAddress tenantAddress = new TenantAddress();
		tenant.setTenantId(1);
		tenant.setTenantName("Aman");
		tenant.setTenantAge(22);
		tenant.setEmail("aman@xyz.com");
		tenant.setIdType("Aadhar");
		tenant.setIdNo("12345678XXX");
		tenantAddress.setId(1);
		tenantAddress.setHouseNo(20);
		tenantAddress.setCity("Ranchi");
		tenantAddress.setCountry("India");
		tenantAddress.setPin(987654);
		tenantAddress.setState("Jharkhand");
		tenantAddress.setStreet("Hec");

		Tenant tenant1 = new Tenant();
		TenantAddress tenantAddress1 = new TenantAddress();
	
		tenant1.setTenantId(2);
		tenant1.setTenantName("John");
		tenant1.setTenantAge(22);
		tenant1.setEmail("john@xyz.com");
		tenant1.setIdType("Aadhar");
		tenant1.setIdNo("987645678XXX");
		tenantAddress1.setId(2);
		tenantAddress1.setHouseNo(40);
		tenantAddress1.setCity("Ranchi");
		tenantAddress1.setCountry("India");
		tenantAddress1.setPin(987654);
		tenantAddress1.setState("Jharkhand");
		tenantAddress1.setStreet("Hec");

		
		List<Tenant> tenants = new ArrayList<>();
		tenants.add(tenant);
		tenants.add(tenant1);

		when(tenantRepository.findAll()).thenReturn(tenants);

		List<Tenant> tenantList = tenantService.viewAllTenants();
		assertEquals(2, tenantList.size());

	}		
	
	@Test
	public void testUpdateTenant() {
	   
		Tenant tenant=new Tenant();
		TenantAddress tenantAddress = new TenantAddress();
		tenant.setTenantId(1);
		tenant.setTenantName("Aman");
		tenant.setTenantAge(22);
		tenant.setEmail("aman@xyz.com");
		tenant.setIdType("Aadhar");
		tenant.setIdNo("12345678XXX");
		tenantAddress.setId(1);
		tenantAddress.setHouseNo(20);
		tenantAddress.setCity("Ranchi");
		tenantAddress.setCountry("India");
		tenantAddress.setPin(987654);
		tenantAddress.setState("Jharkhand");
		tenantAddress.setStreet("Hec");

	    when(tenantRepository.findById(1)).thenReturn(Optional.of(tenant));
	    when(tenantRepository.save(tenant)).thenReturn(tenant);

	    tenant.setTenantName("JBN");
		tenant.setTenantAge(23);

	   Tenant updatedTenant = tenantService.updateTenant(tenant);

	    verify(tenantRepository, times(1)).findById(1);
	    verify(tenantRepository, times(1)).save(tenant);
	    assertEquals(tenant, updatedTenant);
	    assertEquals("JBN", updatedTenant.getTenantName());
	    assertEquals(23, updatedTenant.getTenantAge());
	    
	}

	@Test
	public void testDeleteTenant() {		
	
		Tenant tenant=new Tenant();
		TenantAddress tenantAddress = new TenantAddress();
		tenant.setTenantId(1);
		tenant.setTenantName("Aman");
		tenant.setTenantAge(22);
		tenant.setEmail("aman@xyz.com");
		tenant.setIdType("Aadhar");
		tenant.setIdNo("12345678XXX");
		tenantAddress.setId(1);
		tenantAddress.setHouseNo(20);
		tenantAddress.setCity("Ranchi");
		tenantAddress.setCountry("India");
		tenantAddress.setPin(987654);
		tenantAddress.setState("Jharkhand");
		tenantAddress.setStreet("Hec");

		when(tenantRepository.findById(1)).thenReturn(Optional.of(tenant));

		doNothing().when(tenantRepository).delete(tenant);

		tenantService.deleteTenant(1);

		verify(tenantRepository, times(1)).findById(1);
		verify(tenantRepository, times(1)).delete(tenant);

	}

	@Test
	public void testDeleteTenantWihException() {
		Tenant tenant=new Tenant();
		TenantAddress tenantAddress = new TenantAddress();
		tenant.setTenantId(1);
		tenant.setTenantName("Aman");
		tenant.setTenantAge(22);
		tenant.setEmail("aman@xyz.com");
		tenant.setIdType("Aadhar");
		tenant.setIdNo("12345678XXX");
		tenantAddress.setId(1);
		tenantAddress.setHouseNo(20);
		tenantAddress.setCity("Ranchi");
		tenantAddress.setCountry("India");
		tenantAddress.setPin(987654);
		tenantAddress.setState("Jharkhand");
		tenantAddress.setStreet("Hec");

		when(tenantRepository.findById(10))
				.thenThrow(new TenantNotFoundException("Tenant is not existing with id:10"));

		assertThrows(TenantNotFoundException.class, () -> tenantService.deleteTenant(10));

		verify(tenantRepository, times(0)).delete(tenant);
	}

	
}
