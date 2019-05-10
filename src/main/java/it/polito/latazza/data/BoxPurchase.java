package it.polito.latazza.data;
import java.util.Date;

public class BoxPurchase extends Transaction {
	
	//default serialVersion id
	private static final long serialVersionUID = 1L;
	
	Integer quantity;
	Beverage beverage;
	
	public BoxPurchase(Integer ID, Date date, Integer quantity, Beverage beverage) {
		
		super(ID, date);
		this.quantity = quantity;
		this.beverage = beverage;
		
		this.WriteObjectToFile(this);
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
		return  this.getDate().toString() + " " + "BUY " + beverage.getName() + " " + quantity.toString();
	}
	
	
}
