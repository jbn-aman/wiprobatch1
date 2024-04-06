package com.Day7;

import java.util.Scanner;

public class CharacterFinderMain {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterFinder finder = new CharacterFinder();

        System.out.print("Enter the string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter the index: ");
        String index = scanner.nextLine();

        char result = finder.characterLocator(inputString, index);
     
        System.out.println("Character at index " + index + ": " + result);
        
        scanner.close();
    }
}