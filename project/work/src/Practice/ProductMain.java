package Practice;

public class ProductMain {

	public static void main(String[] args) {
		
		Product p1 = new Product(); 
			
		p1.setProductId(1010);
		p1.setProductName("Iphone 15");
		p1.setProductPrice(100000);
		
		System.out.println("Id is : "+p1.getpID());
		System.out.println("Product name is : "+p1.getName());
		System.out.println("Price is : "+p1.getPrice());
		
		System.out.println();
		
		Product p2 = new Product();
		
		p2.setProductName("Iphone 14");
		p2.setProductId(1011);
		p2.setProductPrice(90000);
		System.out.println("Id is : "+p2.getpID());
		System.out.println("Product name is : "+p2.getName());
		System.out.println("Price is : "+p2.getPrice());
	
			
		}

	}


