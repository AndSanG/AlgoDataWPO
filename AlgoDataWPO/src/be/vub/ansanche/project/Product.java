package be.vub.ansanche.project;

public class Product {
	private String name;
	private int barcodeId;
	
	public Product(String name, int barcodeId) {
		this.setName(name);
		this.setBarcodeId(barcodeId);
	}

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
}
