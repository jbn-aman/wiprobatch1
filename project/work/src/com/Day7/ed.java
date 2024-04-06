package com.Day7;

import java.util.Arrays;
import java.util.List;

public class ed {
    public static void main(String[] args) {
        AlphabetChecker checker = new AlphabetChecker();

        // Sample inputs
        List<String> input1 = Arrays.asList("Java", "code");
        System.out.println("Sample Input 1: " + checker.checkAlphabets(input1)); // Expected output: Given list contains only alphabet strings

        List<String> input2 = Arrays.asList("Java!!", "Code**");
        System.out.println("Sample Input 2: " + checker.checkAlphabets(input2)); // Expected output: Given list contains non alphabet strings
    }
}

