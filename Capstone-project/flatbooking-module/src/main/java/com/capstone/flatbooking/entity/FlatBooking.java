package com.capstone.flatbooking.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="flatBooking_tbl")
public class FlatBooking {
	
	private int flatId;

	@Id
	@Column(name="booking_id",length=5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookingId;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@NotNull(message = "Booking from date is required")
	@FutureOrPresent(message = "Booking from date must be present or future date")	
	private LocalDate bookingFromDate;
	
	@NotNull(message = "Booking from date is required")
	@Future(message = "Booking to date must be in the future")
	private LocalDate bookingToDate;
	
	private double advancePaid;
	
	@Column(name="tenant_id")
	private int tenantId;
	
	@Column(name="booking_status")
	private String bookingStatus;
	
}
