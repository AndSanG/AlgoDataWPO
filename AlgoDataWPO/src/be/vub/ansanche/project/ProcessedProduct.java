package be.vub.ansanche.project;

public class ProcessedProduct extends Product {
	
	private float price;
	private float count;
	

	public ProcessedProduct(String name, int barcodeId, float price, float count) {
		super(name, barcodeId);
		this.price = price;
		this.count = count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}
	
	
}
