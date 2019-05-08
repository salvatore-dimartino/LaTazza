package it.polito.latazza.data;

public class BoxPurchase {
	
	Integer quantity;
	Beverage beverage;
	
	public BoxPurchase(Integer quantity, Beverage beverage){
		
		this.quantity = quantity;
		this.beverage = beverage;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getString() {
		return  super.getDate().toString() + " " + "BUY " + beverage.getName() + " " + quantity.toString();
	}
	
	
}
