package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;
import be.vub.ansanche.project.FreshProductOrder;

public class GroceryStoreManager implements GroceryStoreInterface{

	private LinkedList shelfProducts = new LinkedList();
	private LinkedList freshProducts = new LinkedList();
	private LinkedList clientList = new LinkedList();
	private Queue freshProductsQueue = new Queue();
	private Queue freshProductsQueueUnatended = new Queue();

	private int clientNumber;

	public GroceryStoreManager() {
		super();
		clientNumber = 0;
	}

	public void addProduct(String name, float price, int barcodeId, int count) {
		Product product = new ShelfProduct(name, barcodeId, price, count);
		shelfProducts.addFirst(product);
	}

	public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
		Product freshProduct = new FreshProduct(name, barcodeId, pricePerKg, amountInKg);	
		freshProducts.addFirst(freshProduct);
	}

	public int addClient(String name) {
		this.clientNumber = this.clientNumber + 1;
		int id = this.clientNumber; 
		Client client = new Client(name, id);
		clientList.addFirst(client);
		return id;
	}


	public void addToBasket(int barcodeId, int count, int customerId) {
		//search for the product in the list
		ShelfProduct product = new ShelfProduct(barcodeId,count);
		for (int i = 0; i < shelfProducts.size(); i++) {
			ShelfProduct p = (ShelfProduct) shelfProducts.get(i); 
			if(product.compareTo(p)==0) {
				//fetch information for the product
				product.setName(p.getName());
				product.setPrice(p.getPrice());
				//decrease number in grocery store list
				p.setCount(p.getCount()-product.getCount());
			}
			
			
		}
		//search for the client in the list
		Client c = new Client(customerId);
		for (int i = 0; i < clientList.size(); i++) {
			Client client = (Client) clientList.get(i);
			if(c.compareTo(client)==0) {
				//Check if the client has previously added the product
				int n = client.basket.getProducts().size();
				if(n==0) {
					client.basket.addProduct(product);
				}else {
					boolean shouldAdd = true;
					for (int j = 0; j < client.basket.getProducts().size(); j++) {
						ShelfProduct p = (ShelfProduct)client.basket.getProducts().get(j);
						if(product.compareTo(p)==0) {
							shouldAdd = false;
							p.setCount(p.getCount()+product.getCount());
						}
					}
					if(shouldAdd) {
						client.basket.addProduct(product);
					}
				}
			}
		}
		//decrease the number from database
		
	}

	public void removeFromBasket(int barcodeId, int count, int customerId) {
		
		ShelfProduct product = new ShelfProduct(barcodeId,count);
		for (int i = 0; i < shelfProducts.size(); i++) {
			ShelfProduct p = (ShelfProduct) shelfProducts.get(i); 
			if(product.compareTo(p)==0) {
				//increase number in grocery store list
				p.setCount(p.getCount()+product.getCount());
			}
			
			
		}
		//search for the client in the list
		Client c = new Client(customerId);
		int n = clientList.size();

		for (int i = 0; i < n ; i++) {
			Client client = (Client) clientList.get(i);
			int m = client.basket.getProducts().size();
			if(c.compareTo(client)==0 && m!=0) {
				for (int j = 0; j < m; j++) {
					ShelfProduct basketProduct = (ShelfProduct)client.basket.getProducts().get(j);
					if (product.compareTo(basketProduct)==0) {
						basketProduct.setCount(basketProduct.getCount()-product.getCount());
						if(basketProduct.getCount()<=0) {
							client.basket.removeProduct(basketProduct);
						}
					}
				}
			}
		}	
	}

	public void printBasket(int customerId) {
		Client c = new Client(customerId);
		for (int i = 0; i < clientList.size(); i++) {
			Client client = (Client) clientList.get(i);
			if(c.compareTo(client)==0) {
				System.out.println(client.getName() + "'s basket : \n" + client.basket.getProducts());
			}
		}	

	}

	public float computeBasketPrice(int customerId) {
		float total = 0;
		Client c = new Client(customerId);
		for (int i = 0; i < clientList.size(); i++) {
			Client client = (Client) clientList.get(i);
			if(c.compareTo(client)==0) {
				int n = client.basket.getProducts().size();
				for (int j = 0; j < n; j++) {
					Product product= (Product) client.basket.getProducts().get(j);
					total += product.getTotalPrice();
				}
			}
		}
		return total;
	}


	public void requestFreshProduct(int barcodeId, float amount, int customerId) {
		FreshProduct freshProduct = new FreshProduct(barcodeId,amount);
		for (int i = 0; i < freshProducts.size(); i++) {
			FreshProduct p = (FreshProduct) freshProducts.get(i); 
			if(freshProduct.compareTo(p)==0) {
				//fetch information for the product
				freshProduct.setName(p.getName());
				freshProduct.setPricePerKg(p.getPricePerKg());
			}
			FreshProductOrder order = new FreshProductOrder(freshProduct, customerId);
			freshProductsQueue.push(order);
		}
	}

	public boolean serveNextRequest() {
		boolean served =false;
		if(freshProductsQueue.size()>0) {
			FreshProductOrder order = (FreshProductOrder)freshProductsQueue.pop();
			for (int i = 0; i < freshProducts.size(); i++) {
				FreshProduct p = (FreshProduct) freshProducts.get(i); 
				if(order.getFreshProduct().compareTo(p)==0) {
					//fetch information for the product
					if (order.getFreshProduct().getAmountInKg()<p.getAmountInKg()) {
						//add to client basket
						Client c = new Client(order.getClientId());
						for (int j = 0; j < clientList.size(); j++) {
							Client client = (Client) clientList.get(j);
							if(c.compareTo(client)==0) {
								client.basket.addProduct(order.getFreshProduct());
							}
						}
						served = true ;
						//decrease number in grocery store list
						p.setAmountInKg(p.getAmountInKg()-order.getFreshProduct().getAmountInKg());
					}else {
						freshProductsQueueUnatended.push(order);
					}	
				}
			}
	
		}
		return served;
	}

	public void printUnservedRequests() {
		freshProductsQueueUnatended.print();
	}


	//extra methods 
	public LinkedList getShelfProducts() {
		return shelfProducts;
	}

	public LinkedList getFreshProducts() {
		return freshProducts;
	}

	public LinkedList getClientList() {
		return clientList;
	}

}
