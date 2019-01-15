package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.Tree;

public class ShoppingList {
private Tree products;
	
	public ShoppingList() {
		this.products = new Tree();
	}
	
	public void addProduct(Product product) {
		products.insert(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public Tree getProducts() {
		return products;
	}

}
