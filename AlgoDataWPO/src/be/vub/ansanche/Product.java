package be.vub.ansanche;

public class Product {
	private String productName;
	private float productPrice;
	private int productId;
	
	public Product(String productName,float productPrice, int productId, int quantity) {
		this.setProductName(productName);
		this.setProductPrice(productPrice);
		this.setProductId(productId);
	}

	public String productName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float productPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int productId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
