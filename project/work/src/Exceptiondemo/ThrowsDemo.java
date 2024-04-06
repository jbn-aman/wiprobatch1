package Exceptiondemo;


public class ThrowsDemo {

	public static void main(String[] args) {
		
		System.out.println("Main Starts");
		
		ThrowsDemo throwsDemo = new ThrowsDemo();
		
		try {
			int result = throwsDemo.division(20,0);
			System.out.println("Result: "+result);
		}
		catch(ArithmeticException e) {
			System.out.println("Dominator should not be zero");
		}
		System.out.println("Main Ends");
	}
		
		int division(int a , int b) throws ArithmeticException {
			int c = a/b;
			return c;
		
		}
	}
