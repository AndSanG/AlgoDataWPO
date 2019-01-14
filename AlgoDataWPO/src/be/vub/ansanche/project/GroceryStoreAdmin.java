package be.vub.ansanche.project;
import be.vub.ansanche.dataStructures.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class GroceryStoreAdmin {

	GroceryStore groceryStore = new GroceryStore();

	public void runDemo() {

		//load Departments
		loadDepartments();
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
		//shopping list
		
		groceryStore.addToShoppingList(6001, 2, 1);
		
		groceryStore.addToShoppingList(6002, 3, 1);
		groceryStore.addToShoppingList(6051, 5, 1);
		groceryStore.addToShoppingList(6101, 1, 1);
		groceryStore.addToShoppingList(6151, 1, 1);
		groceryStore.addToShoppingList(6201, 1, 1);
		groceryStore.addToShoppingList(6251, 3, 1);
		
		groceryStore.removeFromShoppingList(6251, 1, 1);
		groceryStore.printShoppingList(1);
		
		//basket
		groceryStore.addToBasket(6001, 2, 1);
		groceryStore.addToBasket(6002, 3, 1);
		groceryStore.addToBasket(6051, 5, 1);
		groceryStore.removeFromBasket(6001, 1, 1);
		groceryStore.checkout(1);
		
		groceryStore.printShoppingHistory(1);
		
		groceryStore.addToBasket(6001, 2, 1);
		groceryStore.addToBasket(6002, 3, 1);
		groceryStore.addToBasket(6051, 5, 1);
		groceryStore.removeFromBasket(6001, 1, 1);
		groceryStore.checkout(1);
		
		groceryStore.printShoppingHistory(1);
		
		/*


		//Michael basket
		groceryStore.addToBasket(6101, 2, 2);
		groceryStore.addToBasket(6102, 3, 2);
		groceryStore.addToBasket(6151, 5, 2);
		groceryStore.addToBasket(6152, 1, 2);
		groceryStore.addToBasket(6153, 3, 2);
		groceryStore.addToBasket(6201, 1, 2);
		groceryStore.removeFromBasket(6152, 1, 2);
		groceryStore.checkout(2);


		//Anna basket
		groceryStore.addToBasket(6201, 12, 3);
		groceryStore.addToBasket(6203, 4, 3);
		groceryStore.addToBasket(6251, 1, 3);
		groceryStore.addToBasket(6252, 1, 3);
		groceryStore.removeFromBasket(6201, 3, 3);
		groceryStore.addToBasket(6253, 1, 3);
		groceryStore.removeFromBasket(6203, 2, 3);
		groceryStore.checkout(3);


		//Paulina Basket
		groceryStore.addToBasket(6301, 5, 4);
		groceryStore.addToBasket(6302, 3, 4);
		groceryStore.addToBasket(6303, 5, 4);
		groceryStore.addToBasket(6351, 2, 4);
		groceryStore.addToBasket(6352, 1, 4);
		groceryStore.addToBasket(6353, 1, 4);
		groceryStore.removeFromBasket(6301, 1, 4);
		groceryStore.checkout(4);

		//Greg Basket
		groceryStore.addToBasket(6452, 32, 5);
		groceryStore.addToBasket(6451, 4, 5);
		groceryStore.checkout(5);
		*/
		


	}
	public void testGraph() {
		loadDepartments();
		loadConnections();
		groceryStore.getGraph().print();
		
		System.out.println(groceryStore.getGraph().topologicalSorting());
	}

	public void loadDepartments() {
		loadDepartments("src/Departments.csv");
		//groceryStore.addDepartment("Entrance");
		//groceryStore.addDepartment("FreshProducts");
		//groceryStore.addDepartment("Checkout");
		
	}

	private void loadDepartments(String FilePath) {
		Vector departments = readFile(FilePath);
		for (int i = 0; i < departments.size(); i++) {
			String[] department = (String[])departments.get(i);
			groceryStore.addDepartment(department[0]);
		} 
	}
	private void loadConnections() { 
		
		groceryStore.connectDepartments("Entrance","CannedProducts");
		groceryStore.connectDepartments("Entrance","Cereals");
		
		groceryStore.connectDepartments("DairyProducts","Fruits");
		
		groceryStore.connectDepartments("FrozenProducts","FreshProducts");
		groceryStore.connectDepartments("FrozenProducts","Checkout");
		
		groceryStore.connectDepartments("Breads&Fluor","FrozenProducts");
		groceryStore.connectDepartments("Breads&Fluor","DairyProducts");
		groceryStore.connectDepartments("Breads&Fluor","Checkout");
		
		groceryStore.connectDepartments("Cereals","Breads&Fluor");
		groceryStore.connectDepartments("Cereals","Alcohol");
		groceryStore.connectDepartments("Cereals","FreshProducts");
		groceryStore.connectDepartments("Cereals","Checkout");
		
		groceryStore.connectDepartments("Clean&Home","Cereals");
		groceryStore.connectDepartments("Clean&Home","Drinks");
		
		groceryStore.connectDepartments("CannedProducts","Clean&Home");
		groceryStore.connectDepartments("CannedProducts","Cereals");
		groceryStore.connectDepartments("CannedProducts","Checkout");
		
		groceryStore.connectDepartments("Fruits","Vegetables");
		
		groceryStore.connectDepartments("Vegetables","Breads&Fluor");
		
		groceryStore.connectDepartments("Drinks","Alcohol");
		
		groceryStore.connectDepartments("Alcohol","Vegetables");
		
		groceryStore.connectDepartments("FreshProducts","Checkout");
		
		
	}


	public void loadShelfProducts() {
		
		for (int i = 0; i < groceryStore.getDepartments().size(); i++) {
			String department = (String) groceryStore.getDepartments().get(i);
			loadProducts(department);
		}
	}

	private void loadProducts(String department) {

		String filePath = String.format("src/%s.csv", department);
		Vector products = readFile(filePath);
		for (int i = 0; i < products.size(); i++) {
			String[] product = (String[])products.get(i);
			groceryStore.addProduct(department, product[0], Float.parseFloat(product[1]), Integer.valueOf(product[2]), Integer.valueOf(product[3]));
		} 
	}

	private Vector readFile(String FilePath) {

		String csvFile = FilePath;
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

	public void printInventory() {
		System.out.println("Total :" + String.format("%.2f",groceryStore.computeBasketPrice(4))+'\n');

	}

}
