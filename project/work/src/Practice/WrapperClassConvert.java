package Practice;

import java.util.Scanner;

public class WrapperClassConvert {

	public Object convertToWrapper(Object input) {

		if (input instanceof Integer) {
			return Integer.valueOf((int) input);
		} 
		else if (input instanceof Long) {
			return Long.valueOf((long) input);
		} 
		else if (input instanceof Double) {
			return Double.valueOf((double) input);
		} 
		else if (input instanceof Float) {
			return Float.valueOf((float) input);
		} 
		else if (input instanceof Character) {
			return Character.valueOf((char) input);
		} 
		else if (input instanceof Byte) {
			return Byte.valueOf((byte) input);
		} 
		else if (input instanceof Short) {
			return Short.valueOf((short) input);
		} 
		else if (input instanceof Boolean) {
			return Boolean.valueOf((boolean) input);
		} 
		else if (input == null) {
			return "Give proper primitive type as input";
		} 
		else {
			return "Give proper primitive type as input";
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WrapperClassConvert converter = new WrapperClassConvert();

		System.out.println("Sample Input:");
		Object input = null;
		if (scanner.hasNextInt()) {
			input = scanner.nextInt();
		} 
		else if (scanner.hasNextLong()) {
			input = scanner.nextLong();
		} 
		else if (scanner.hasNextDouble()) {
			input = scanner.nextDouble();
		} 
		else if (scanner.hasNextFloat()) {
			input = scanner.nextFloat();
		} 
		else if (scanner.hasNext()) {
			input = scanner.next();
		} 
		else if (scanner.hasNextBoolean()) {
			input = scanner.nextBoolean();
		}

		Object result = converter.convertToWrapper(input);
		System.out.println("Output: " + result);
	}
}