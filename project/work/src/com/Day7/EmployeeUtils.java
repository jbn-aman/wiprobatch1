package com.Day7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


	public class EmployeeUtils {

		public static String generateEmployeeId(String lastName, String firstName, LocalDate dob) {

	        String lastNamePrefix = lastName.substring(0, Math.min(lastName.length(), 3)).toUpperCase();

	        String firstNamePrefix = firstName.substring(0, Math.min(firstName.length(), 2)).toUpperCase();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
	        String dobStr = dob.format(formatter);

	        return lastNamePrefix + firstNamePrefix + dobStr;

}
}
