package com.capstone.tenantmodule.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tenant_tbl")
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="tenant_id")
	private int tenantId;
	
	@Column(name="tenant_name")
	@NotNull(message="Enter Tenant name!")
	private String tenantName;
	
	@Column(name="tenant_age")
	private int tenantAge;
	
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull(message="Enter Tenant address!")
	private TenantAddress tenantAddress;
	
	private String email;
	
	private String idType;
	
	private String idNo;
	
}
