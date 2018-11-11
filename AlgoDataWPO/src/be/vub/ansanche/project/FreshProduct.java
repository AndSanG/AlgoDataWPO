package be.vub.ansanche.project;

public class FreshProduct extends Product{
		
	private float pricePerKg;
	private float amountInKg;
	
	public FreshProduct(String name, int barcodeId, float pricePerKg, float amountInKg) {
		super(name, barcodeId);
		this.pricePerKg = pricePerKg;
		this.amountInKg = amountInKg;
	}
	public FreshProduct(int barcodeId, float amountInKg) {
		this("",barcodeId,0f,amountInKg);
	}

	public float getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(float pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public float getAmountInKg() {
		return amountInKg;
	}

	public void setAmountInKg(float amountInKg) {
		this.amountInKg = amountInKg;
	}
	
	public float getTotalPrice() {
		return this.getPricePerKg()*this.getAmountInKg();
	}
	
	public String toString() {
		String product = this.getName() + " " + this.getPricePerKg() + " " + this.getBarcodeId() + " " + getAmountInKg() +'\n' ;
		return product;
	}
	
	
}
