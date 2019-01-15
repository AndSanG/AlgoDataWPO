package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.Graph;
import be.vub.ansanche.dataStructures.Queue;
import be.vub.ansanche.dataStructures.Tree;
import be.vub.ansanche.dataStructures.TreeAction;
import be.vub.ansanche.dataStructures.Vector;
import be.vub.ansanche.dataStructures.Tree.TreeNode;

public class GroceryStore implements GroceryStoreInterface{

	private Vector departments = new Vector();
	private Tree shelfProducts = new Tree();
	private Tree freshProducts = new Tree();
	private Tree clientList = new Tree();
	private Queue freshProductsQueue = new Queue();
	private Queue freshProductsQueueUnatended = new Queue();
	private Graph graph = new Graph();
	private float auxiliar  = 0;

	private int clientNumber;

	public GroceryStore() {
		super();
		clientNumber = 0;
	}

	public void addProduct(String department, String name, float price, int barcodeId, int count) {
		Product product = new ShelfProduct(department, name, barcodeId, price, count);
		shelfProducts.insert(product);
	}

	public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
		Product freshProduct = new FreshProduct("Fresh", name, barcodeId, pricePerKg, amountInKg);	
		freshProducts.insert(freshProduct);
	}

	public int addClient(String name) {
		this.clientNumber = this.clientNumber + 1;
		int id = this.clientNumber; 
		Client client = new Client(name, id);
		clientList.insert(client);
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

	public Product searchProduct(int barcodeId, Tree list) {
		Product product = new Product(barcodeId); 	
		return (Product)list.find(product);
	}

	public Client searchClient(int customerId, Tree list) {
		Client client = new Client(customerId);
		return (Client)list.find(client);
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
		String header = String.format("%5s %30s %10s %6s %6s ", 
				"Code", " Product Name", "Quantity ", "P Uni", "Total" );
		System.out.println("----------------------------------------------------------------");
		System.out.println(header);
		System.out.println("----------------------------------------------------------------");
		Tree products = client.getBasket().getProducts();
		products.print();
		System.out.println("----------------------------------------------------------------");
		System.out.println("Total :" + String.format("%.2f",this.computeBasketPrice(customerId))+'\n');
		
	}

	public float computeBasketPrice(int customerId) {
		float total = 0;
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return 0;
		
		client.getBasket().getProducts().traverseInOrder(new TreeAction() {
			
			@Override
			public void run(TreeNode n) {
				// TODO Auto-generated method stub
				Product product= (Product) n.getValue();
				auxiliar += product.getTotalPrice();
			}
		});
		total = auxiliar;
		auxiliar = 0;
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
	
	public void checkout(int customerId) {
		//print the items 
		printBasket(customerId);
		
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;
		
		//addItems to customer history
		Order order = new Order(client.getBasket().getProducts(),computeBasketPrice(customerId));
		client.addOrder(order);
		//remove items form basket 
		client.setBasket(new Basket());
	}

	public void printShoppingHistory(int customerId) {
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;
		
		System.out.println(client.getName() + "'s previous orders : ");
		
		Vector orderHistory = client.getOrderHistory();

		String header = String.format("%5s %30s %10s %6s %6s ", 
				"Code", " Product Name", "Quantity ", "P Uni", "Total" );
		System.out.println("----------------------------------------------------------------");
		System.out.println(header);
		System.out.println("----------------------------------------------------------------");
		System.out.println( orderHistory);
		System.out.println("----------------------------------------------------------------");
		
	}
	
	public void addToShoppingList(int barcodeId, int count, int customerId) {
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
		Product pList = searchProduct(barcodeId, client.getShoppingList().getProducts());
		if(pList==null) {
			//add the product the first time
			client.getShoppingList().addProduct(product);
		}else {
			//modify the quantity of the product
			pList.setQuantity(pList.getQuantity()+product.getQuantity());
		}
	}
	
	public void removeFromShoppingList(int barcodeId, int count, int customerId) {

		//search for the client in the list
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;

		//get the product 
		Product listProduct = (Product)searchProduct(barcodeId, client.getShoppingList().getProducts());
		if(listProduct == null) 
			return;
		
		// control the count
		if (listProduct.getQuantity()<count) {
			return;
		}

		//modify product number if there is less than zero remove from the basket 
		listProduct.setQuantity(listProduct.getQuantity()-count);
		if(listProduct.getQuantity()<=0) {
			client.getShoppingList().removeProduct(listProduct);
		}
		
		Product productInventory = (Product)searchProduct(barcodeId, shelfProducts);
		productInventory.setQuantity(productInventory.getQuantity()+count);

	}
	
	public void printShoppingList(int customerId) {
		
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;
		
		System.out.println(client.getName() + "'s Shopping list : ");
		
		Vector orderHistory = client.getOrderHistory();

		String header = String.format("%5s %30s %10s %6s %6s ", 
				"Code", " Product Name", "Quantity ", "P Uni", "Total" );
		System.out.println("----------------------------------------------------------------");
		System.out.println(header);
		System.out.println("----------------------------------------------------------------");
		client.getShoppingList().getProducts().print();
		System.out.println("----------------------------------------------------------------");
		
	}
	
	public void addDepartment(String departmentName) {
		this.graph.addNode(departmentName);
		this.departments.addFirst(departmentName);
	}

	
	public void connectDepartments(String department1, String department2) {
		this.graph.addEdge(department1	, department2, 1);
	}

	
	public void shortestPath(String department1, String department2) {
		// TODO Auto-generated method stub
		
	}

	
	public void clearShoppingList(int customerId) {
		// TODO Auto-generated method stub
		
	}

	
	public void printsOptimalPath(int customerId) {
		// TODO Auto-generated method stub
		
	}

	public Vector getDepartments() {
		return departments;
	}

	public Graph getGraph() {
		return graph;
	}



}
