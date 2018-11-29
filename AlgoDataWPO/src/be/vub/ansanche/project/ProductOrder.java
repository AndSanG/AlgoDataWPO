package be.vub.ansanche.project;

public class ProductOrder{
	
	private int productId;
	private float amount;
	private int clientId;
	
	
	public ProductOrder(int productId, float amout, int clientId) {
		super();
		this.productId = productId;
		this.clientId = clientId;
		this.amount = amout;
	}
	public int getProductId() {
		return productId;
	}
	
	public int getClientId() {
		return clientId;
	}
	public float getAmount() {
		return amount;
	}
	
	public String toString() {
		String order = String.format("%5s %5s %5s \n",this.productId, this.amount, this.clientId );
		return order;
	}

}
