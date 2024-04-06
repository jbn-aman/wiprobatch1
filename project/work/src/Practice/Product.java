package Practice;

public class Product {
	
	private int productId;
	private String productName;
	private double productPrice;
	
	public void setProductId(int productId) {
	this.productId = productId;
	}
	
	public void setProductName( String productName) {
		this.productName = productName;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getpID() {
		return productId;
	}
	
	public String getName() {
		return productName;
	}
	
	public double getPrice() {
		return productPrice;
		
	}
}



