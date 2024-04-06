package com.Day7;

public class CharacterFinder {
	public char characterLocator(String inputString, String index) {
		try {
			int idx = Integer.parseInt(index);
			if (idx < 0 || idx >= inputString.length()) {
				throw new StringIndexOutOfBoundsException();
			}
			return inputString.charAt(idx);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
			return '0'; 
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("StringIndexOutOfBoundsException");
			return '0'; 
		}
	}
}
