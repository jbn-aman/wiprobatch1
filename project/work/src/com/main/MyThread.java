package com.main;

public class MyThread extends Thread {
	@Override
	public void run() {
		printNumbers();
	}

	private void printNumbers() {
		for (int i = 1; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName() + "= " + i);
		}

	}
}