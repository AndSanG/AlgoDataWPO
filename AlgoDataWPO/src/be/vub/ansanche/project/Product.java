package be.vub.ansanche.project;

public class Product implements Comparable <Product>, Cloneable{
	private String department;
	private String name;
	private int barcodeId;
	
	public Product(String department, String name, int barcodeId) {
		this.setDepartment(department);
		this.setName(name);
		this.setBarcodeId(barcodeId);
	}
	
	public Product(int barcodeId) {
		this.setName("");
		this.setDepartment("");
		this.setBarcodeId(barcodeId);
	}
	
	//getters setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBarcodeId() {
		return barcodeId;
	}

	public void setBarcodeId(int barcodeId) {
		this.barcodeId = barcodeId;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// generic functions
	public void setQuantity(float quantity) {}
	
	public float getQuantity() {return 0;}
	
	public float getTotalPrice() {return 0;}
	
	
	//comparing methods 
	public int compareTo(Product product) {
		return Integer.compare(this.barcodeId, product.getBarcodeId());
	}
	
	public boolean equals(Object object) {
		if(this == object) return true;
		else if (this == null || getClass() != object.getClass()) return false;
		else if (object instanceof Product) {
			Product product = (Product) object;
			if(product.getBarcodeId() == barcodeId) return true;
		}
		return false;
	}
	
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
