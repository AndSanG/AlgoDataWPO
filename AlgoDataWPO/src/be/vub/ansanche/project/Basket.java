/*******************************************************************************
 * '
 * Basket.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a client basket
 * 
 ******************************************************************************/
package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;

public class Basket {
	private Tree products;
	
	
	public Basket() {
		this.products = new Tree();
	}
	
	/**
	 * Adds a product to the basket 
	 * 
	 * @param product represent all the information of a product
	 */
	public void addProduct(Product product) {
		products.insert(product);
	}
	
	/**
	 * Removes a product to the basket 
	 * 
	 * @param product represent all the information of a product
	 */
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public Tree getProducts() {
		return this.products;
	}
}
