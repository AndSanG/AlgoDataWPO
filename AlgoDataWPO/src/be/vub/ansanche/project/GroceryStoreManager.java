package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.LinkedList;

public class GroceryStoreManager implements GroceryStoreInterface{
	
	private LinkedList processedProducts = new LinkedList();
	private LinkedList freshProducts = new LinkedList();

	public void addProduct(String name, float price, int barcodeId, int count) {
		Product product = new ProcessedProduct(name, barcodeId, price, count);
		//processedProducts.addFirst(product);
	}
	
	public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
		FreshProduct freshProduct = new FreshProduct(name, barcodeId, pricePerKg, amountInKg);	
	}

	public int addClient(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addToBasket(int barcodeId, int count, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public void removeFromBasket(int barcodeId, int count, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public void printBasket(int customerId) {
		// TODO Auto-generated method stub
		
	}

	public float computeBasketPrice(int customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void requestFreshProduct(int barcodeId, float amount, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public boolean serveNextRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	public void printUnservedRequests() {
		// TODO Auto-generated method stub
		
	}

}
