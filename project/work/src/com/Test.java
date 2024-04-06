package com;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Enter name");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		System.out.println("Hello "+name);
		sc.close();
	}

}
