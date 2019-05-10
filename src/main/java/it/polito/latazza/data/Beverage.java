package it.polito.latazza.data;

public class Beverage {
	
	private Integer ID;
	private String name;
	private Integer price;
	private Integer quantityPerBox;
	private Integer availableQuantity;
	
	public Beverage(Integer ID, String name, Integer price, Integer quantityPerBox, Integer availableQuantity) {
		
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.quantityPerBox = quantityPerBox;
		this.availableQuantity = availableQuantity;
	}
	
	public Integer getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getQuantityPerBox() {
		return quantityPerBox;
	}
	
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setQuantityPerBox(Integer quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	
	
}
