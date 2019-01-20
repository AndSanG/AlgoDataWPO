/*******************************************************************************
 * '
 * GroceryStoreAdmin.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class creates an instance of GorceryStore and feed all the grocery store 
 * instance methods with the necessary information to represent a real  
 * grocery store.
 * 
 ******************************************************************************/
package be.vub.ansanche.project;
import be.vub.ansanche.dataStructures.*;
import be.vub.ansanche.dataStructures.Tree.TreeNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class GroceryStoreAdmin {

	GroceryStore groceryStore = new GroceryStore();
	
	/** Starts the grocery store demo
	*/
	public void runDemo() {

		setupStore();
		
		// demo
		
		//fresh products Orders 
		groceryStore.requestFreshProduct(5101, 5, 1);
		groceryStore.requestFreshProduct(5101, 10,2);
		groceryStore.requestFreshProduct(5101, 4,3);
		groceryStore.requestFreshProduct(5101, 5,4); //not served 
		groceryStore.requestFreshProduct(5101, 5,5);

		groceryStore.printRequests();

		groceryStore.serveNextRequest();
		groceryStore.serveNextRequest();

		groceryStore.printRequests();

		groceryStore.serveNextRequest();
		groceryStore.serveNextRequest();
		groceryStore.serveNextRequest();

		groceryStore.printRequests();

		groceryStore.printUnservedRequests();

		
		//Andres 
		
		//First purchase 
		
		//fresh Product
		groceryStore.addToBasket(6001, 2, 1);
		groceryStore.addToBasket(6002, 3, 1);
		groceryStore.addToBasket(6051, 5, 1);
		groceryStore.removeFromBasket(6001, 1, 1);
		groceryStore.checkout(1);
		
		//Second purchase
		groceryStore.addToShoppingList(6001, 2, 1);
		groceryStore.addToShoppingList(6002, 3, 1);
		groceryStore.addToShoppingList(6051, 5, 1);
		groceryStore.addToShoppingList(6101, 1, 1);
		groceryStore.addToShoppingList(6151, 1, 1);
		groceryStore.addToShoppingList(6152, 2, 1);
		groceryStore.addToShoppingList(6251, 3, 1);
		
		groceryStore.removeFromShoppingList(6251, 3, 1);
		groceryStore.removeFromShoppingList(6051, 1, 1);
		
		groceryStore.printShoppingList(1);
		
		groceryStore.printsOptimalPath(1);
		
		Tree shoppingList = groceryStore.getShoppingList(1);
		shoppingList.traverseInOrder(new TreeAction() {
			
			@Override
			public void run(TreeNode n) {
				
				Product product = (Product) n.getValue();
					groceryStore.addToBasket(product.getBarcodeId(), (int)(product.getQuantity()), 1);
			}
		});
		
		groceryStore.checkout(1);
		
		groceryStore.printShoppingHistory(1);
		
		


		//Michael basket
		
		groceryStore.addToShoppingList(6001, 2, 2);
		groceryStore.addToShoppingList(6051, 5, 2);
		groceryStore.addToShoppingList(6101, 1, 2);
		groceryStore.addToShoppingList(6151, 1, 2);
		groceryStore.addToShoppingList(6202, 3, 2);
		groceryStore.addToShoppingList(6251, 3, 2);
		
		groceryStore.printShoppingList(2);
		
		groceryStore.printsOptimalPath(2);
		
		Tree shoppingList2 = groceryStore.getShoppingList(2);
		shoppingList2.traverseInOrder(new TreeAction() {
			
			@Override
			public void run(TreeNode n) {
				
				Product product = (Product) n.getValue();
					groceryStore.addToBasket(product.getBarcodeId(), (int)(product.getQuantity()), 2);
			}
		});
		
		groceryStore.checkout(2);
		
		groceryStore.printShoppingHistory(2);
		

		//Paulina Basket
		
		groceryStore.addToShoppingList(6051, 5, 4);
		groceryStore.addToShoppingList(6202, 3, 4);
		
		groceryStore.printShoppingList(4);
		
		groceryStore.printsOptimalPath(4);
		
		Tree shoppingList3 = groceryStore.getShoppingList(4);
		shoppingList3.traverseInOrder(new TreeAction() {
			
			@Override
			public void run(TreeNode n) {
				
				Product product = (Product) n.getValue();
					groceryStore.addToBasket(product.getBarcodeId(), (int)(product.getQuantity()), 4);
			}
		});
		
		groceryStore.checkout(4);
		
		groceryStore.printShoppingHistory(4);
		
		System.out.println("Sortesth path among departments \n");
		
		System.out.println(groceryStore.ENTRANCE + " - " + groceryStore.CHECKOUT);
		groceryStore.shortestPath(groceryStore.ENTRANCE, groceryStore.CHECKOUT);
		System.out.println("\n");
		
		System.out.println("Entrance" + " - " + "FreshProducts");
		groceryStore.shortestPath("Entrance", "FreshProducts");
		System.out.println("\n");
		
		System.out.println("FreshProducts" + " - " + "Vegetables");
		groceryStore.shortestPath("FreshProducts", "Vegetables");
		System.out.println("\n");
		
		System.out.println("FreshProducts" + " - " + "Checkout");
		groceryStore.shortestPath("FreshProducts", "Checkout");
		System.out.println("\n");
		
		System.out.println("Cereals" + " - " + "Fruits");
		groceryStore.shortestPath("Cereals", "Fruits");
		System.out.println("\n");

	}
	
	/** Initializes all the information needed for the grocery store
	*/
	public void setupStore(){
		//load departments
		loadDepartments();
		
		//load Shelf products
		loadShelfProducts();
		
		//Load Fresh products
		loadFreshProducts();
		
		//load CLients
		loadClients();
		
		// load the rest of the grocery infrastructure 
		groceryStore.addDepartment(groceryStore.ENTRANCE);
		groceryStore.addDepartment(groceryStore.FRESHPRODUCTS);
		groceryStore.addDepartment(groceryStore.CHECKOUT);
		
		//load Departments Graph
		loadDepartmentsGraph();
	}
	
	/** Reads all the departments from an external file
	*/
	public void loadDepartments() {
		loadDepartments("src/Departments.csv");
	}
	
	/** Reads all the departments
	 * @param filePath The file that have the products information
	*/
	private void loadDepartments(String filePath) {
		Vector departments = readFile(filePath);
		for (int i = 0; i < departments.size(); i++) {
			String[] department = (String[])departments.get(i);
			groceryStore.addDepartment(department[0]);
		} 
	}
	
	/** Loads all the infrastructure related information
	 *  needed to build a graph that represent the grocery store departments 
	*/
	private void loadDepartmentsGraph() { 
		//Entrance
		groceryStore.connectDepartments("Entrance","CannedProducts");
		
		//CannedProducts
		groceryStore.connectDepartments("CannedProducts","Cereals");
		groceryStore.connectDepartments("CannedProducts","DairyProducts");
		
		//Cereals
		groceryStore.connectDepartments("Cereals","DairyProducts");
		groceryStore.connectDepartments("Cereals","FreshProducts");

		//FreshProducts
		groceryStore.connectDepartments("FreshProducts","DairyProducts");
		
		//DairyProducts
		groceryStore.connectDepartments("DairyProducts","Breads&Fluor");
		groceryStore.connectDepartments("DairyProducts","Fruits");
		
		
		//Breads&Fluor
		groceryStore.connectDepartments("Breads&Fluor","Vegetables");
		
		
		//Vegetables
		groceryStore.connectDepartments("Vegetables","Fruits");
		groceryStore.connectDepartments("Vegetables","Checkout");
		
		//Fruits
		groceryStore.connectDepartments("Fruits","Breads&Fluor");
		groceryStore.connectDepartments("Fruits","Checkout");
		
	}

	/** Loads the shelf products from a file
	*/
	public void loadShelfProducts() {
		
		for (int i = 0; i < groceryStore.getDepartments().size(); i++) {
			String department = (String) groceryStore.getDepartments().get(i);
			loadProducts(department);
		}
	}
	
	/** Loads the products of a department
	 * @param department department name
	*/
	private void loadProducts(String department) {

		String filePath = String.format("src/%s.csv", department);
		Vector products = readFile(filePath);
		for (int i = 0; i < products.size(); i++) {
			String[] product = (String[])products.get(i);
			groceryStore.addProduct(department, product[0], Float.parseFloat(product[1]), Integer.valueOf(product[2]), Integer.valueOf(product[3]));
		} 
	}

	/** Reads all the departments
	 * @param filePath The file that have the products information
	*/
	private Vector readFile(String filePath) {

		String csvFile = filePath;
		String line = "";
		String cvsSplitBy = ",";
		Vector list = new Vector(50);

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] product = line.split(cvsSplitBy);
				list.addLast(product);
			}
			return list;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/** Loads the fresh products to the grocery store
	*/
	public void loadFreshProducts() {
		groceryStore.addFreshProduct("Beef", 	2.05f, 5101, 20);
		groceryStore.addFreshProduct("Pork", 	2.65f, 5102, 20);
		groceryStore.addFreshProduct("Turkey", 	3.45f, 5103, 20);
		groceryStore.addFreshProduct("Chicken", 2.55f, 5104, 20);
		groceryStore.addFreshProduct("Shrimp", 	4.05f, 5105, 20);
		groceryStore.addFreshProduct("Crab", 	5.55f, 5106, 10);
	}

	/** Loads the clients of the grocery store
	*/
	public void loadClients() {
		groceryStore.addClient("Andres");
		groceryStore.addClient("Michael");
		groceryStore.addClient("Anna");
		groceryStore.addClient("Paulina");
		groceryStore.addClient("Greg");
	}
	
	/** Prints the inventory of the grocery store
	*/
	public void printInventory() {
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(4))+'\n');

	}

}
