/*******************************************************************************
 * '
 * FreshProduct.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a shelf product in the grocery store
 * Contains extends the Product class with particular properties of a fresh product 
 * 
 ******************************************************************************/
package be.vub.ansanche.project;

public class FreshProduct extends Product{
		
	private float pricePerKg;
	private float amountInKg;
	
	public FreshProduct(String department, String name, int barcodeId, float pricePerKg, float amountInKg) {
		super(department, name, barcodeId);
		this.pricePerKg = pricePerKg;
		this.amountInKg = amountInKg;
	}
	public FreshProduct(int barcodeId, float amountInKg) {
		this("","",barcodeId,0f,amountInKg);
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
	
	
	
	public float getQuantity() {
		return getAmountInKg();
	}
	
	public void setQuantity(float quantity) {
		setAmountInKg( quantity);
	}
	
	public float getTotalPrice() {
		return this.getPricePerKg()*this.getAmountInKg();
	}
	
	public String toString() {
		String product =	String.format("%5s %30s %8.2fKg %6.2f %6.2f", 
							"~"+this.getBarcodeId(), this.getName(), this.getAmountInKg(), getPricePerKg(), this.getTotalPrice());
				
		return product;
	}
	
	
}
