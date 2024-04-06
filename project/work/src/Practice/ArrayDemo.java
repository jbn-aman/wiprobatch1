package Practice;

public class ArrayDemo {

	public static void main(String[] args) {
		Product1 p1 = new Product1(1100,"xyx",20000);
		Product1 p2 = new Product1(1000,"xyz",25000);
		Product1 p3 = new Product1("xttttz",100,35000);
		
		Product1[] myProduct = new Product1[3];
		
		myProduct[0] = p1;
		myProduct[1] = p2;
		myProduct[2] = p3;
		
		for(int i = 0;i<myProduct.length; i++) {
			myProduct[i].displayProductDetails();
			
		}
		
	}

}
