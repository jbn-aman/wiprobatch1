package com.Day7;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class AlphabetChecker {
	public String checkAlphabets(List<String> strings) {
		if (strings.isEmpty()) {
			return "Give Proper input";
		}
		Predicate<String> isAlphabetic = str -> str.chars().allMatch(Character::isLetter);
		if (strings.stream().allMatch(isAlphabetic)) {
			return "Given list contains only alphabet strings";
		} else {
			return "Given list contains non alphabet strings";
		}
	}

	public static void main(String[] args) {
		AlphabetChecker checker = new AlphabetChecker();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter strings: ");
		String input = sc.next();
		if (input.isEmpty()) {
			System.out.println("Give proper input not empty list");
		} else {
			List<String> strings = List.of(input.split("\\s+"));
			System.out.println(checker.checkAlphabets(strings));
		}
		sc.close();
	}
}