package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.Vector;

public class Basket {
	private Vector basketList;
	
	public Basket() {
		this.basketList = new Vector(10);
	}
	
	public void addProductToBasket(Product product) {
		basketList.addLast(product);
	}
	
	public void removeProductFromBasket(Product product) {
		//implement
	}
	
	public Vector getBasketProducts() {
		return basketList;
	}
}
