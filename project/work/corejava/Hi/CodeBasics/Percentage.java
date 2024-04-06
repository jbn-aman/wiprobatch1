
import java.util.Scanner;

public class Percentage {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Marks for 1st subject");
		int sub1 = sc.nextInt();

		System.out.println("Enter Marks for 2nd subject");
		int sub2 = sc.nextInt();

		System.out.println("Enter Marks for 3rd subject");
		int sub3 = sc.nextInt();

		System.out.println("Enter Marks for 4th subject");
		int sub4 = sc.nextInt();

		System.out.println("Enter Marks for 5th subject");
		int sub5 = sc.nextInt();

		double total = sub1+sub2+sub3+sub4+sub5;
		double percentage = total/5;
		System.out.println("Percentage: "+percentage);



	}

}