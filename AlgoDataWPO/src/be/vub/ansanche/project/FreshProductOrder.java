package be.vub.ansanche.project;

public class FreshProductOrder{
	private FreshProduct freshProduct;
	private int clientId;
	public FreshProductOrder(FreshProduct freshProduct, int clientId) {
		super();
		this.freshProduct = freshProduct;
		this.clientId = clientId;
	}
	public FreshProduct getFreshProduct() {
		return freshProduct;
	}
	public void setFreshProduct(FreshProduct freshProduct) {
		this.freshProduct = freshProduct;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
