package com.main;

import java.util.*;

enum Order {
	ALPHABETIC_ASCENDING, ALPHABETIC_DESCENDING, LENGTH_THEN_ALPHABETIC_ASCENDING, INPUT_ORDER
}

public class UniqueWordExtractor {

	public static List<String> extractUniqueWords(String paragraph, Order order) {
		if (paragraph == null || paragraph.isEmpty()) {
			return Collections.emptyList();
		}

		String[] words = paragraph.trim().split("\\s+");

		Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));

		List<String> uniqueWordsList = new ArrayList<>(uniqueWords);

		switch (order) {
		case ALPHABETIC_ASCENDING:
			Collections.sort(uniqueWordsList);
			break;
		case ALPHABETIC_DESCENDING:
			Collections.sort(uniqueWordsList, Collections.reverseOrder());
			break;
		case LENGTH_THEN_ALPHABETIC_ASCENDING:
			Collections.sort(uniqueWordsList,
					Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
			break;
		case INPUT_ORDER:
			break;
		default:
			throw new IllegalArgumentException("Unknown order type");
		}
		

		return uniqueWordsList;
	}

	public static void main(String[] args) {
		String paragraph = "This is a sample paragraph with some sample words.";
		System.out.println("Alphabetic Ascending Order: " + extractUniqueWords(paragraph, Order.ALPHABETIC_ASCENDING));
		System.out
				.println("Alphabetic Descending Order: " + extractUniqueWords(paragraph, Order.ALPHABETIC_DESCENDING));
		System.out.println("Length then Alphabetic Ascending Order: "
				+ extractUniqueWords(paragraph, Order.LENGTH_THEN_ALPHABETIC_ASCENDING));
		System.out.println("Input Order: " + extractUniqueWords(paragraph, Order.INPUT_ORDER));
	}
}
