package be.vub.ansanche;

public class Client {
	
	private String clientName;
	private Basket clientBasket;
	
	public Client(String clientName) {
		this.setClientName(clientName);
		this.clientBasket = new Basket();
	}

	public String clientName() {
		return clientName;
	}
	
	private void setClientName(String productName) {
		this.clientName = productName;
	}
	
	public Basket clientBasket() {
		return clientBasket;
	}
	
}
