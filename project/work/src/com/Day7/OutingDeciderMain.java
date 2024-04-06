package com.Day7;

public class OutingDeciderMain {
	
	public static void main(String[] args) {
        OutingDecider outingDecider1 = new OutingDecider("Aman", 22, "NA", 0);
        System.out.println(outingDecider1.outingChecker(10));
        System.out.println();
        OutingDecider outingDecider2 = new OutingDecider("Aryan", 19, "NA", 18);
        System.out.println(outingDecider2.outingChecker(0)); 
        System.out.println();
        OutingDecider outingDecider3 = new OutingDecider("Alex", 30, "Lucie", 25);
        System.out.println(outingDecider3.outingChecker(10)); 
    }
    }



