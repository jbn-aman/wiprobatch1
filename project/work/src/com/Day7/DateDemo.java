package com.Day7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateDemo {
	
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDateTime todayDateTime = LocalDateTime.now();
		System.out.println(todayDateTime);
		
		LocalDate DOB = LocalDate.of(2001, 11, 24);
		System.out.println("D.O.B: "+DOB);
		
		LocalDate dateofPassing = LocalDate.of(2023,Month.MAY,15);
		System.out.println("Date of Passing: "+dateofPassing);
		
		LocalDate todaysDate = LocalDate.now();
		
		LocalDate afterDays = todaysDate.plusDays(20);
		System.out.println("After 20 days: "+afterDays);
		System.out.println(afterDays.getDayOfWeek());
				
		
	}

}
