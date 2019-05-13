package it.polito.latazza.data;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class Beverage {
	
	private Integer ID;
	private String name;
	private Integer price;
	private Integer quantityPerBox;
	private Integer availableQuantity;
	
	private JSONObject json = new JSONObject();
	private List<String> attributes = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public Beverage(Integer ID, String name, Integer price, Integer quantityPerBox, Integer availableQuantity) {
		
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.quantityPerBox = quantityPerBox;
		this.availableQuantity = availableQuantity;

		attributes.add(0, name);
		attributes.add(1, price.toString());
		attributes.add(2, quantityPerBox.toString());
		attributes.add(3, availableQuantity.toString());
		
		json.put(ID.toString(), attributes);
	
	}
	

	public List<String> getAttributes() {
		return attributes;
	}


	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}


	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
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
