package be.vub.ansanche.project;

public class Client implements Comparable<Client> {
	
	private String name;
	private int id;
	private Basket basket;
	
	public Client(String clientName, int id){
		this.setName(clientName);
		this.setId(id);
		this.basket = new Basket();
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
	// TODO set the id on the builder and do not allow to change form outside
	// there must be a place where the numbers are stored 
	public void setId(int id) {
		this.id = id;
	}
	
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
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
