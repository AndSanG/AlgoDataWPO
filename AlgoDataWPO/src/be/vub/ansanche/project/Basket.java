package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;

public class Basket {
	private LinkedList products;
	
	public Basket() {
		this.products = new LinkedList();
	}
	
	public void addProduct(Product product) {
		products.addLast(product);
	}
	
	public void removeProduct(Product product) {
		int n = products.size();
		for (int i = 0; i < n; i++) {
			Product p = (Product)products.get(i);
			int com = p.compareTo(product);
			if(com==0){
				//System.out.println("afdaf" + product);
				//products.remove(0);
			}
		}
	}
	
	public LinkedList getProducts() {
		return products;
	}
}
