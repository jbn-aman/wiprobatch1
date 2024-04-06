package Practice;

import java.util.Scanner;

public class FlowControlDemo {

	public static void main(String[] args) {
		
		Scanner marks = new Scanner(System.in);
		System.out.println("Obtained marks: ");
		
		int Marks = marks.nextInt();
		
	    
		
		
		if(Marks >= 90)
		
		System.out.println("A");
		
		else if(Marks >= 80)
			System.out.println("B");
		else if(Marks >= 70)
			System.out.println("c");
		else if(Marks >= 60)
			System.out.println("D");
		else
			System.out.println("Fail");
		
			
			
			
		}
		

	}


