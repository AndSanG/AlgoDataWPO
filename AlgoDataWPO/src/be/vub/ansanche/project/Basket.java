package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;

public class Basket {
	private Vector products;
	
	public Basket() {
		this.products = new Vector();
	}
	
	public void addProduct(Product product) {
		products.addLast(product);
	}
	
	public void removeProduct(Product product) {
		
		int code = product.getBarcodeId();
		product = new Product(code);
		for (int i = 0; i < products.size(); i++) {

			Product p = (Product) products.get(i);
			boolean comparison = product.compareTo(p)==0;
			if(comparison) {
				products.remove(i);
			}
		}
		
	}
	
	public Vector getProducts() {
		return products;
	}
}
