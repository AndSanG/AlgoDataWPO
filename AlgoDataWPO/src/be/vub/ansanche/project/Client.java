package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;

public class Client implements Comparable<Client> {
	
	private String name;
	private int id;
	private Basket basket;
	private ShoppingList shoppingList;
	private Vector orderHistory;

	
	public Client(String clientName, int id){
		this.setName(clientName);
		this.setId(id);
		this.basket = new Basket();
		this.orderHistory = new Vector(10);
		this.shoppingList = new ShoppingList();
	}
	
	public Client(int id){
		this("",id);
	}
	
	public int compareTo(Client client) {
		return Integer.compare(this.id, client.getId());
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String productName) {
		this.name = productName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	public Vector getOrderHistory() {
		return orderHistory;
	}

	public void addOrder(Order order) {
		this.orderHistory.addLast(order);
	}
	
	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public boolean equals(Object object) {
		if(this == object) return true;
		else if (this == null || getClass() != object.getClass()) return false;
		else if (object instanceof Client) {
			Client client = (Client) object;
			if(client.getId() == id) return true;
		}
		return false;
	}
	
	public String toString() {
		String client = this.getId() + " " + this.getName() + '\n';
		return client;
	}
	
}
