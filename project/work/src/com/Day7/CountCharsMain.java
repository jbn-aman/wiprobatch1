package com.Day7;

import java.util.Map;

public class CountCharsMain {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o', 's','e'};
        Map<Character, Integer> charCount = CountChars.countChars(arr);
        System.out.println(charCount);
    }
}