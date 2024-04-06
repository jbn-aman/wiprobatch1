package Practice;

public class Product1Main {

	public static void main(String[] args) {

		Product1 product1 = new Product1();
		product1.displayProductDetails();
		
		System.out.println();

		Product1 product2 = new Product1(1100,"xyx",20000);
		product2.displayProductDetails();
		
		System.out.println();
		
		Product1 product3 = new Product1(1000,"xyz",25000);
		product3.displayProductDetails();
		
		System.out.println();
		
		Product1 product4 = new Product1("xttttz",100,35000);
		product4.displayProductDetails();


	}

}
