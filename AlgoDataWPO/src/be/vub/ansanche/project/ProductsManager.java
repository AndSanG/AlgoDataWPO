package be.vub.ansanche.project;

import be.vub.ansanche.Utilities;
import be.vub.ansanche.dataStructures.Vector;

public class ProductsManager {
	protected Vector productsList = new Vector(10);
	protected Client client = new Client("Andres");
	
	public void runDemo() {
		loadProductList();
		showProductsList();
		
		addProductToBasket((Product)productsList.get(0));
		addProductToBasket((Product)productsList.get(3));
		addProductToBasket((Product)productsList.get(2));
		addProductToBasket((Product)productsList.get(2));
		
		showBasketList();
		removeProductFromBasket();
		
		showBasketList();
		
		
	}
	
	
	//Basket
	public void addProductToBasket(Product product) {
		client.clientBasket().getBasketProducts().addLast(product);
	}
	public void removeProductFromBasket() {
		client.clientBasket().getBasketProducts().removeLast();
	}
	
	
	//Products
	private void loadProductList() {
		//productId From 501 and so on, could improve
		Product apple = new Product("Apple", 1, 501, 10);
		Product bread = new Product("Bread", 2, 502, 5);
		Product milk = new Product("Milk", 1.75f, 503, 20);
		Product orangeJuice = new Product("Orange Juice", 2.25f, 504, 6);
		Product cigarrets = new Product("Cigarrets", 5.34f, 580,0);	
		
		productsList.addLast(apple);
		productsList.addLast(bread);
		productsList.addLast(milk);
		productsList.addLast(orangeJuice);
		productsList.addLast(cigarrets);
		
	}
	
	private void showBasketList(){
		
		
		Utilities.println("Products in " + client.getName()+"'s Basket :");
		
		for (int i = 0; i < client.clientBasket().getBasketProducts().size(); i++) {
			Product product = (Product) productsList.get(i);
			String message = product.getName() + " ";
			Utilities.print(message); 	
		} 
		Utilities.println(" ");
		Utilities.println(" ");
	}
	
	private void showProductsList(){
		
		Utilities.println("Available Products :");	
		
		for (int i = 0; i < productsList.size(); i++) {
			Product product = (Product) productsList.get(i);
			String message = product.getName();
			Utilities.println(message); 	
		} 
		Utilities.println(" ");
	}
}
