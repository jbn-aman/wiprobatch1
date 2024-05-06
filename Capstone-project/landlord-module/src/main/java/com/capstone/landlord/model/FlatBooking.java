package com.capstone.landlord.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatBooking {

	private int flatId;

	private int bookingId;

	private LocalDate bookingDate;

	private LocalDate bookingFromDate;

	private LocalDate bookingToDate;

	private double advancePaid;

	private int tenantId;

	private String bookingStatus;

}