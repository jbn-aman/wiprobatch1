package com.capstone.landlord.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="landlord_tbl")
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="landlord_id")
    private int landlordId;
    
    @NotNull(message="Enter Name")
    @Column(name="landlord_name")
    private String landlordName;
    
    @Column(name="landlord_age")
    private int landlordAge;
        
    @Column(name="mobile_no", unique=true )
    private String mobileNo;
    
    @Column(unique=true)
    private String email;
}

    
