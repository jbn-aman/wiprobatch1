package com.Day7;

import java.util.HashMap;
import java.util.Map;

public class CountChars {
    public static Map<Character, Integer> countChars(char[] arr) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (char c : arr) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        return charCountMap;
    }
}
