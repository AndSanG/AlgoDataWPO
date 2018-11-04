package be.vub.ansanche.project;

public class Client {
	
	private String name;
	private Basket basket;
	
	public Client(String clientName) {
		this.setName(clientName);
		this.basket = new Basket();
	}

	public String getName() {
		return name;
	}
	
	private void setName(String productName) {
		this.name = productName;
	}
	
	public Basket clientBasket() {
		return basket;
	}
	
}
