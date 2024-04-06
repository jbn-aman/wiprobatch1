package Practice;

public class Product1 {
	
	private int productId;
	private String productName;
	private double productPrice;
	
	Product1(){
		productId = 101;
		productName = "Iphone";
		productPrice = 99000;
	}
	
	Product1(int pId, String pName, double Price){
		productId = pId;
		productName  = pName;
		productPrice = Price;
	
	}
	
	Product1(String prName,int prId, double pPrice){
		
		productId = prId;
		productName  = prName;
		productPrice = pPrice;
		
	}
	
	void displayProductDetails() {
		System.out.println("Product Id : "+productId);
		System.out.println("Product Name : "+productName);
		System.out.println("Product Price : "+productPrice);
		
	}
	
	}


