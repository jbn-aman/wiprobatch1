package com.capstone.flat.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="flat_tbl")
public class Flat {
   
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="flat_id")
    private int flatId;
    
    @Positive(message=("Enter Positive values"))
    private float cost;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private FlatAddress flatAddress;
   
    @NotNull(message=("Can't be empty"))
    private String availability;
    
    private int landlordId;
   
}