import java.util.Scanner;

public class TomAndJerry {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        
        // Read the user input
        int number = scanner.nextInt();
        
        // Close the Scanner to avoid resource leak
        scanner.close();

        // Check conditions and print Tom or Jerry accordingly
        if (number % 2 != 0 && number >= 20 && number <= 30) {
            System.out.println("Tom");
        } else if (number % 2 == 0 && number >= 20 && number <= 30) {
            System.out.println("Jerry");
        }
    }
}