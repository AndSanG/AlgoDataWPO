/*******************************************************************************
 * '
 * GroceryStore.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class implements all the requirements of GroceryStore needed to represent
 * a grocery store.
 * 
 ******************************************************************************/
package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.DictionaryPair;
import be.vub.ansanche.dataStructures.DictionaryTree;
import be.vub.ansanche.dataStructures.Graph;
import be.vub.ansanche.dataStructures.Graph.Node;
import be.vub.ansanche.dataStructures.PathInfo;
import be.vub.ansanche.dataStructures.Queue;
import be.vub.ansanche.dataStructures.Stack;
import be.vub.ansanche.dataStructures.Tree;
import be.vub.ansanche.dataStructures.TreeAction;
import be.vub.ansanche.dataStructures.Vector;
import be.vub.ansanche.dataStructures.Tree.TreeNode;

public class GroceryStore implements GroceryStoreInterface{

	public static final String ENTRANCE = "Entrance";
	public static final String CHECKOUT = "Checkout";
	public static final String FRESHPRODUCTS = "FreshProducts";
	
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
	
	/**
	 * Adds a product to the store 
	 * 
	 * @param department - represents a department to which is the product added
	 * @param name - represents the name of the new product
	 * @param price - represents the price of the new product
	 * @param barcodeId - is the bar-code number of the new product 
	 * @param count - is the number of items of the new product in the store
	 */
	public void addProduct(String department, String name, float price, int barcodeId, int count) {
		Product product = new ShelfProduct(department, name, barcodeId, price, count);
		shelfProducts.insert(product);
	}

	/**
	 * Adds a fresh product to the store
	 * 
	 * @param name - represents the name of the new fresh product
	 * @param pricePerKg - represents the price of the new fresh product
	 * @param barcodeId - is the bar-code number of the new fresh product (identifying only the type)
	 * @param amountInKg - is the amount in kilograms the new fresh product in the store
	 */
	public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
		Product freshProduct = new FreshProduct("Fresh", name, barcodeId, pricePerKg, amountInKg);	
		freshProducts.insert(freshProduct);
	}

	/**
	 * Registers a new client in the store
	 * 
	 * @param name - name of the client
	 * @return a unique id number identifying the client
	 */
	public int addClient(String name) {
		this.clientNumber = this.clientNumber + 1;
		int id = this.clientNumber; 
		Client client = new Client(name, id);
		clientList.insert(client);
		return id;
	}

	/**
	 * Adds a product to the basket for a specific client. Make sure you adjust
	 * the amount of the product that is available at the store for others. 
	 * 
	 * @param barcodeId - the bar code of the product that is added to the basket 
	 * @param count - number of the packages of the product that is added to the basket 
	 * @param customerId - the client id that is adding the product to the basket
	 */
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

	/**
	 * Search a product in a binary tree list with the barcodeId 
	 * 
	 * @param barcodeId - the bar code of the product to search
	 */
	public Product searchProduct(int barcodeId, Tree list) {
		Product product = new Product(barcodeId); 	
		return (Product)list.find(product);
	}

	/**
	 * Search a client in a binary tree list with the customerId 
	 * 
	 * @param customerId - the  code of the client to search
	 */
	public Client searchClient(int customerId, Tree list) {
		Client client = new Client(customerId);
		return (Client)list.find(client);
	}

	/**
	 * Removes a product to the basket for a specific client. Make sure you adjust
	 * the amount of the product that is available at the store for others.
	 * 
	 * @param barcodeId - the bar code of the product that is removed added from the basket
	 * @param count - number of the packages of the product that is removed from the basket
	 * @param customerId - the client id that is removing the product from the basket
	 */
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
	
	/**
	 * Prints the content of a basket for a specific client
	 * 
	 * @param customerId - the client id whose basket will be printed out
	 */
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
		client.getBasket().getProducts().print();
		System.out.println("----------------------------------------------------------------");
		System.out.println("Total :" + String.format("%.2f",this.computeBasketPrice(customerId))+'\n');
		
	}
	
	/**
	 * Computes the total price of the basket for a specific client
	 * 
	 * @param customerId - the client id whose basket will be printed out
	 * @return total price of products in the basket
	 */
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

	/**
	 * Requests an amount in kg of the fresh product. If the request is
	 * successful, it is automatically added to the basket. 
	 * 
	 * @param barcodeId - the bar code of the fresh product that is requested by the client
	 * @param amount - amount in kilograms that is requested by the client
	 * @param customerId - the client id of the client making the request
	 */
	public void requestFreshProduct(int barcodeId, float amount, int customerId) {
		ProductOrder order = new ProductOrder(barcodeId,amount,customerId);
		freshProductsQueue.push(order);
	}

	/**
	 * Processes the next request in the queue. If the request can be produces
	 * then it adds the product to the basket. 
	 * 
	 * Note: Fresh product cannot be removed from the basket. Once it is
	 * requested it has to be paid by the client
	 * 
	 * @return true if the next request was successfully processed, false otherwise
	 */
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

	/**
	 * This method will print currently unserved requests that are waiting to be processed 
	 */
	public void printRequests() {
		if (freshProductsQueue.size()>0) {
			System.out.println("Fresh Product Queue");
			freshProductsQueue.print();
		}else {
			System.out.println("There is no orders left");
		}
		
	}
	
	/**
	 * This method adds a new department to the store
	 * 
	 * @param departmentName - is the name of the department that is added to the store
	 */
	public void printUnservedRequests() {
		
		if (freshProductsQueueUnatended.size()>0) {
			System.out.println("Fresh Product Not served ");
			freshProductsQueueUnatended.print();
		}else {
			System.out.println("There is no unserved oreders");
		}
		
	}
	
	/**
	 * Checkouts specified client and prints a bill.
	 * 
	 * @param customerId - the client id of the client that checkouts the items from the
	 *     basket and finalizes the purchase 
	 */
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
		//clear shopping list 
		clearShoppingList(customerId);
	}

	/**
	 * Prints a summary of previous purchases
	 * 
	 * @param customerId - the client id for which the shopping history will be printed
	 */
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
	
	/**
	 * Adds a product to the shopping list of a specific client. 
	 * 
	 * @param barcodeId - the bar code of the product that is added to the shopping list 
	 * @param count - number of the packages of the product that is added to the shopping list
	 * @param customerId - the client id that is adding the product to the shopping list
	 */
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
	
	/**
	 * Removes a product out the shopping list of a specific client. 
	 * 
	 * @param barcodeId - the bar code of the product that is added to the shopping list 
	 * @param count - number of the packages of the product that is added to the shopping list
	 * @param customerId - the client id that is adding the product to the shopping list
	 */
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
	
	/**
	 * Prints a the client shopping list
	 * 
	 * @param customerId - the client id for which the shopping history will be printed
	 */
	public void printShoppingList(int customerId) {
		
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;
		
		System.out.println(client.getName() + "'s Shopping list : ");

		String header = String.format("%5s %30s %10s %6s %6s ", 
				"Code", " Product Name", "Quantity ", "P Uni", "Total" );
		System.out.println("----------------------------------------------------------------");
		System.out.println(header);
		System.out.println("----------------------------------------------------------------");
		client.getShoppingList().getProducts().print();
		System.out.println("----------------------------------------------------------------");
		
	}
	
	/**
	 * Return the shopping list of a client 
	 * 
	 * @param customerId - the  code of the client to search
	 */
	public Tree getShoppingList(int customerId) {
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return null;
		
		return client.getShoppingList().getProducts();
		
	}
	
	/**
	 * 
	 * @param department - name of the first department that will be added to the graph
	 * that represents the grocery store
	 */
	public void addDepartment(String department) {
		this.graph.addNode(department);
		this.departments.addFirst(department);
	}

	/**
	 * Connecting 2 departments. Two departments are connected when there is a direct aisle
	 * between them. 
	 * 
	 * @param department1 - name of the first department that will be connected.
	 * @param department2 - name of the second department that will be connected.
	 */
	public void connectDepartments(String department1, String department2) {
		this.graph.addEdge(department1	, department2, 1);
	}
	
	/**
	 * Return a list of the departments that the client must visit to collect all the items 
	 * in its shopping list 
	 * 
	 * @param customerId - the  code of the client to search
	 */
	private Vector createDepartamentList(int customerId) {
		
		Vector departmentsToVisit = new Vector();
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return null;
		
		client.getShoppingList().getProducts().traverse(new TreeAction() {
			
			@Override
			public void run(TreeNode n) {
				
				Product product = (Product)n.getValue();
				if(departmentsToVisit.contains(product.getDepartment())==null) {
					departmentsToVisit.addLast(product.getDepartment());
				}
		
			}
		});
		return departmentsToVisit;
	}
	
	/**
	 * Return a list of the departments that the client must visit to collect all the items 
	 * in its shopping list ordered according to the bes way to traverse the store
	 * 
	 * @param customerId - the  code of the client to search
	 */
	public Vector orderDepartmentList(int customerId) {
		Vector departmentsToVisit = createDepartamentList(customerId);
		Vector departmentsOrdered = new Vector();
		if(departmentsToVisit == null)
			return null;
		
		Stack graphTS = graph.topologicalSorting();
		departmentsOrdered.addLast(ENTRANCE);
		while(!graphTS.isEmpty()) {
			Node node = (Node) graphTS.pop();
			String department = (String) node.getLabel();
			if(departmentsToVisit.contains(department) != null) {
				departmentsOrdered.addLast(department);
			}
		}
		departmentsOrdered.addLast(CHECKOUT);
		return departmentsOrdered;
	}
	
	/**
	 * Removes all items from the shopping list. 
	 * 
	 * @param customerId - the client id for which the shopping list will be cleared.
	 */
	public void clearShoppingList(int customerId) {
	
		Client client = searchClient(customerId, clientList);
		if(client == null)
			return;
		
		client.setShoppingList(new ShoppingList());
	}

	/**
	 * Prints optimal path to buy all products from the shopping list 
	 * 
	 * @param customerId - the client id for which the shopping list will be cleared.
	 */
	public void printsOptimalPath(int customerId) {
		
		Vector departmentsOrdered = orderDepartmentList(customerId);
		if (departmentsOrdered ==null)
			return;
		
		Vector path = new Vector();
		int n = 0;
		for (int i = 0; i < departmentsOrdered.size()-1; i++) {
			
			Vector route = connectDeps((String)departmentsOrdered.get(i), (String)departmentsOrdered.get(i+1));
			path.append(route);
		}
		path.addLast((String)departmentsOrdered.getLast());
		
		Client client = searchClient(customerId, clientList);
		
		if(client == null)
			return;
		
		System.out.println(client.getName() + "'s optimal path is :");
		
		for (int i = 0; i < path.size(); i++) {
			String format = String.format("%d %s",i+1, path.get(i));
			System.out.println(format);
		}
		System.out.println("");
		
	}
	
	/**
	 * Prints the shortest path between 2 departments. 
	 * 
	 * @param department1 - name of the source department.
	 * @param department2 - name of the destination department.
	 */
	public void shortestPath(String department1, String department2) {
		Vector path = connectDeps(department1, department2);
		path.addLast(department2);
		System.out.println(path);
	}
	
	/**
	 * return a list with the shortest path between 2 departments. 
	 * 
	 * @param department1 - name of the source department.
	 * @param department2 - name of the destination department.
	 */
	public Vector connectDeps(String department1, String department2) {
		PathInfo pathInfo = this.graph.shortestPath(department1);
		DictionaryTree precedents = pathInfo.getPrecedents();
		
		Vector path = new Vector();
		String precedent = (String) precedents.find(department2);
		while (precedent != precedents.find(department1)) {
			path.addFirst(precedent);
			precedent = (String) precedents.find(precedent);
		}
		return path;
	
	}
	
	/**
	 * return a list with the departments. 
	 */
	public Vector getDepartments() {
		return departments;
	}

}
