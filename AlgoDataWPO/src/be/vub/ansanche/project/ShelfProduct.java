package be.vub.ansanche.project;

public class ShelfProduct extends Product {
	
	private float price;
	private int count;
	

	public ShelfProduct(String department, String name, int barcodeId, float price, int count) {
		super(department, name, barcodeId);
		this.price = price;
		this.count = count;
	}
	public ShelfProduct(int barcodeId,int count) {
		this("","",barcodeId,0f,count);
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public float getQuantity() {
		return getCount();
	}
	
	public void setQuantity(float quantity) {
		setCount((int) quantity);
	}
	
	public float getTotalPrice() {
		return this.getPrice()*this.getCount();
	}
	
	
	public String toString() {
		
		String product =  String.format("%5s %30s %10s %6.2f %6.2f", 
				this.getBarcodeId(), "{"+this.getDepartment()+"}  " + this.getName(), this.getCount(), getPrice(), this.getTotalPrice());
		
		return product;
	}

}
