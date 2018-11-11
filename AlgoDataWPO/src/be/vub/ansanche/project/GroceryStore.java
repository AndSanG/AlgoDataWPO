package be.vub.ansanche.project;

public class GroceryStore {
	
	GroceryStoreManager groceryStore = new GroceryStoreManager();
	
	public void runDemo() {
		
		//load Shelf products
		loadShelfProducts();
		//Load Fresh products
		loadFreshProducts();
		//load CLients
		loadClients();
		//fresh products Orders 
		groceryStore.requestFreshProduct(5101, 5, 1);
		groceryStore.requestFreshProduct(5101, 10,2);
		groceryStore.requestFreshProduct(5101, 4,3);
		groceryStore.requestFreshProduct(5101, 5,4);
		groceryStore.requestFreshProduct(5101, 5,5);
		
		groceryStore.serveNextRequest();
		groceryStore.serveNextRequest();
		groceryStore.serveNextRequest();
		groceryStore.serveNextRequest();
		
		
		
		//Andres basket
		//groceryStore.addToBasket(5001, 1, 1);
		/*groceryStore.addToBasket(5002, 4, 1);
		groceryStore.addToBasket(5001, 1, 1);
		groceryStore.addToBasket(5005, 1, 1);
		//groceryStore.removeFromBasket(5001, 1, 1);
		groceryStore.addToBasket(5006, 4, 1);
		groceryStore.addToBasket(5001, 2, 1);*/
		groceryStore.printBasket(1);
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(1))+'\n');
		
		
		//Michael basket
		groceryStore.addToBasket(5001, 2, 2);
		groceryStore.addToBasket(5002, 3, 2);
		groceryStore.addToBasket(5004, 5, 2);
		groceryStore.addToBasket(5006, 1, 2);
		groceryStore.addToBasket(5002, 3, 2);
		groceryStore.addToBasket(5004, 1, 2);
		groceryStore.printBasket(2);
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(2))+'\n');
		
		//Anna basket
		groceryStore.addToBasket(5012, 12, 3);
		groceryStore.addToBasket(5008, 4, 3);
		groceryStore.addToBasket(5009, 1, 3);
		groceryStore.addToBasket(5011, 1, 3);
		groceryStore.addToBasket(5012, 3, 3);
		groceryStore.addToBasket(5007, 1, 3);
		groceryStore.printBasket(3);
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(3)) +'\n');
		
		//Paulina Basket
		groceryStore.addToBasket(5008, 5, 4);
		groceryStore.addToBasket(5002, 3, 4);
		groceryStore.addToBasket(5003, 5, 4);
		groceryStore.addToBasket(5010, 1, 4);
		groceryStore.addToBasket(5012, 3, 4);
		groceryStore.addToBasket(5011, 1, 4);
		groceryStore.printBasket(4);
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(4))+'\n');
		//Greg Basket
		groceryStore.addToBasket(5012, 24, 5);
		groceryStore.addToBasket(5011, 4, 5);
		groceryStore.printBasket(5);
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(5))+'\n');
		
		System.out.println(groceryStore.getShelfProducts());
		
	}
	

	public void loadShelfProducts() {
		
		groceryStore.addProduct("Apple", 		1.00f, 5001, 50);
		groceryStore.addProduct("Bread", 		2.00f, 5002, 20);
		groceryStore.addProduct("Cheese", 		2.50f, 5003, 10);
		groceryStore.addProduct("Milk", 		1.50f, 5004, 25);
		groceryStore.addProduct("Coffe", 		2.10f, 5005, 20);
		groceryStore.addProduct("Tuna", 		2.45f, 5006, 15);
		groceryStore.addProduct("Rice", 		3.15f, 5007, 15);
		groceryStore.addProduct("Pasta", 		2.45f, 5008, 20);
		groceryStore.addProduct("Tomato Sauce", 2.25f, 5009, 10);
		groceryStore.addProduct("Mayo", 		1.45f, 5010, 25);
		groceryStore.addProduct("Wine", 		3.75f, 5011, 20);
		groceryStore.addProduct("Beer", 		3.05f, 5012, 50);
		
		
	}
	
	public void loadFreshProducts() {
		groceryStore.addFreshProduct("Beef", 	2.05f, 5101, 20);
		groceryStore.addFreshProduct("Pork", 	2.65f, 5102, 20);
		groceryStore.addFreshProduct("Turkey", 	3.45f, 5103, 20);
		groceryStore.addFreshProduct("Chicken", 2.55f, 5104, 20);
		groceryStore.addFreshProduct("Shrimp", 	4.05f, 5105, 20);
		groceryStore.addFreshProduct("Crab", 	5.55f, 5106, 10);
	}
	
	public void loadClients() {
		groceryStore.addClient("Andres");
		groceryStore.addClient("Michael");
		groceryStore.addClient("Anna");
		groceryStore.addClient("Paulina");
		groceryStore.addClient("Greg");
	}
	
}
