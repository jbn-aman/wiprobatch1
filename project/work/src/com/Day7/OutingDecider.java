package com.Day7;

public class OutingDecider {

	private String employeeName;
	private int employeeAge;
	private String spouseName;
	private int spouseAge;

	public OutingDecider(String employeeName, int employeeAge, String spouseName, int spouseAge) {

		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.spouseName = spouseName;
		this.spouseAge = spouseAge;
	}

	public String outingChecker(int ageGap) {
		if (spouseName.equals("NA")) {
			if (employeeAge > 20) {
				return "Enjoy outing";
			} else {
				return "We are planning good for you";
			}
		} else {
			int maxAge = Math.max(employeeAge, spouseAge);
			int minAge = Math.min(employeeAge, spouseAge);
			int ageDifference = maxAge - minAge;
			if (ageDifference < ageGap) {
				return employeeName + " and " + spouseName + " - You are invited";
			}
		}
		return "";
	}

}
