package be.vub.ansanche.project;

public class Client implements Comparable<Client> {
	
	private String name;
	private int id;
	public Basket basket;
	
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

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		String client = this.getId() + " " + this.getName() + '\n';
		return client;
	}

	
}
