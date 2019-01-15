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
		System.out.println("remove");
		/*
		int code = product.getBarcodeId();
		product = new Product(code);
		for (int i = 0; i < products.size(); i++) {

			Product p = (Product) products.get(i);
			boolean comparison = product.compareTo(p)==0;
			if(comparison) {
				products.remove(i);
			}
		}*/
		
	}
	
	public Tree getProducts() {
		return products;
	}

}
