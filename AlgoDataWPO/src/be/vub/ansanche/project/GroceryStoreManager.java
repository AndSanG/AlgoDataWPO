package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.*;
import be.vub.ansanche.project.ProductOrder;

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

	public void addProduct(String department, String name, float price, int barcodeId, int count) {
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
		Product product = (Product)searchProduct(barcodeId, shelfProducts).clone();

		//check if the search do not match a product
		if(product == null) 
			return;

		//set the quantity
		product.setQuantity(count);

		//search for the client in the list
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;

		//check if the product was previously added
		Product pBasket = searchProduct(barcodeId, client.getBasket().getProducts());
		if(pBasket==null) {
			//add the product the first time
			client.getBasket().addProduct(product);
		}else {
			//modify the quantity of the product
			pBasket.setQuantity(pBasket.getQuantity()+product.getQuantity());
		}

		//update the inventory
		Product pInventory = (Product)searchProduct(barcodeId, shelfProducts);
		pInventory.setQuantity(pInventory.getQuantity()-product.getQuantity());

	}

	public Product searchProduct(int barcodeId, LinkedList list) {
		Product product = new Product(barcodeId);
		for (int i = 0; i < list.size(); i++) {

			Product p = (Product) list.get(i);
			boolean comparison = product.compareTo(p)==0;
			if(comparison) {
				product = p;
				return product;
			}
		}
		return null;
	}

	public Client searchClient(int customerId, LinkedList list) {
		Client client = new Client(customerId);
		for (int i = 0; i < list.size(); i++) {
			Client c = (Client) list.get(i);
			if(client.equals(c)) {
				client = c;
				return client;
			}
		}
		return null;
	}


	public void removeFromBasket(int barcodeId, int count, int customerId) {

		

		//search for the client in the list
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;

		//get the product 
		Product basketProduct = (Product)searchProduct(barcodeId, client.getBasket().getProducts());
		if(basketProduct == null) 
			return;
		
		// control the count
		if (basketProduct.getQuantity()<count) {
			return;
		}

		//modify product number if there is less than zero remove from the basket 
		basketProduct.setQuantity(basketProduct.getQuantity()-count);
		if(basketProduct.getQuantity()<=0) {
			client.getBasket().removeProduct(basketProduct);
		}
		
		Product productInventory = (Product)searchProduct(barcodeId, shelfProducts);
		productInventory.setQuantity(productInventory.getQuantity()+count);

	}

	public void printBasket(int customerId) {

		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;

		System.out.println(client.getName() + "'s basket : ");
		String header = String.format("%6s %15s %4s %6s %6s ", 
				"Code", " Product Name", "Q ", "P Uni", "Total" );
		System.out.println("--------------------------------------------");
		System.out.println(header);
		System.out.println("--------------------------------------------");
		System.out.println(client.getBasket().getProducts());
		System.out.println("--------------------------------------------");
		System.out.println("Total :" + String.format("%.2f",this.computeBasketPrice(customerId))+'\n');
		
	}

	public float computeBasketPrice(int customerId) {
		float total = 0;

		Client client = searchClient(customerId, clientList);
		if(client == null)
			return 0;

		int n = client.getBasket().getProducts().size();
		for (int j = 0; j < n; j++) {
			Product product= (Product) client.getBasket().getProducts().get(j);
			total += product.getTotalPrice();
		}
		
		return total;
	}


	public void requestFreshProduct(int barcodeId, float amount, int customerId) {
		ProductOrder order = new ProductOrder(barcodeId,amount,customerId);
		freshProductsQueue.push(order);
	}

	public boolean serveNextRequest() {

		if(!(freshProductsQueue.size()>0))
			return false;
		
		ProductOrder order = (ProductOrder)freshProductsQueue.pop();
		if(order == null) 
			return false;
		
		Product productStock = searchProduct(order.getProductId(), freshProducts);
		if(productStock == null) 
			return false;
		
		Product product = (Product) productStock.clone();
		product.setQuantity(order.getAmount());
		
		if(product.getQuantity()>productStock.getQuantity()) {
			freshProductsQueueUnatended.push(order);
			return false;
		}
		
		Client client = searchClient(order.getClientId(), clientList);
		if(client == null)
			return false;
		
		client.getBasket().addProduct(product);
		
		productStock.setQuantity(productStock.getQuantity()-product.getQuantity());
		
		return true;
		
	}

	public void printRequests() {
		if (freshProductsQueue.size()>0) {
			System.out.println("Fresh Product Queue");
			freshProductsQueue.print();
		}else {
			System.out.println("There is no orders left");
		}
		
	}
	
	public void printUnservedRequests() {
		
		if (freshProductsQueueUnatended.size()>0) {
			System.out.println("Fresh Product Not served ");
			freshProductsQueueUnatended.print();
		}else {
			System.out.println("There is no unserved oreders");
		}
		
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

	public void addDepartment(String departmentName) {
		// TODO Auto-generated method stub

	}

	public void checkout(int customerId) {
		// TODO Auto-generated method stub

	}

	public void printShoppingHistory(int customerId) {
		// TODO Auto-generated method stub

	}

}
