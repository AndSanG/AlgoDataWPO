package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;

public class Basket {
	private Tree products;
	
	public Basket() {
		this.products = new Tree();
	}
	
	public void addProduct(Product product) {
		products.insert(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public Tree getProducts() {
		return this.products;
	}
}
