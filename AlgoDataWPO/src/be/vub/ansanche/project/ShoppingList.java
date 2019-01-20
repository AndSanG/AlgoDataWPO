/*******************************************************************************
 * '
 * ShoppingList.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represent a client shopping list, contains all the products that a
 * client add to purchase once arrive to the grocery store.
 * 
 ******************************************************************************/
package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.Tree;

public class ShoppingList {
private Tree products;
	
	public ShoppingList() {
		this.products = new Tree();
	}
	/**
	 * Adds a product to the shopping List 
	 * 
	 * @param product represent all the information of a product
	 */
	public void addProduct(Product product) {
		products.insert(product);
	}
	
	/**
	 * Removes a product to the shopping List 
	 * 
	 * @param product represent all the information of a product
	 */
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public Tree getProducts() {
		return products;
	}

}
