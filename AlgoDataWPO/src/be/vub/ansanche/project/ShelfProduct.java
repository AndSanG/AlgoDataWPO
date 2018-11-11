package be.vub.ansanche.project;

public class ShelfProduct extends Product {
	
	private float price;
	private int count;
	

	public ShelfProduct(String name, int barcodeId, float price, int count) {
		super(name, barcodeId);
		this.price = price;
		this.count = count;
	}
	public ShelfProduct(int barcodeId,int count) {
		this("",barcodeId,0f,count);
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
	
	public String toString() {
		String product =  " (" + this.getBarcodeId() + ") " + this.getName() + "    " +  this.getCount() + " " + String.format("%.2f",getPrice()) + "     " + String.format("%.2f",this.getTotalPrice())+'\n' ;
		return product;
	}
	
	public float getTotalPrice() {
		return this.getPrice()*this.getCount();
	}
	
}
