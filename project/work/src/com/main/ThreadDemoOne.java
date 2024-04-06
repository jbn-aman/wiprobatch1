package com.main;

public class ThreadDemoOne {
	
	public static void main(String[] args){
		
		System.out.println("***Main Starts***");
		
		MyThread m1 = new MyThread();
		
		m1.setName("T1");
		m1.start();
		
		MyThread m2 = new MyThread();
		
		m2.setName("T1");
		m2.start();
		
		for (int j = 51; j <= 100; j++) {
			System.out.println(Thread.currentThread().getName() + "= " + j);
		}
		
		System.out.println("***Main Ends***");
	
		
	}
}
