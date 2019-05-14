package it.polito.latazza.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	
	public List<String> getAttributes(){
		List<String> attributes = new ArrayList<String>();
		
		attributes.add(0, name);
		attributes.add(1, price.toString());
		attributes.add(2, quantityPerBox.toString());
		attributes.add(3, availableQuantity.toString());
		
		return attributes;
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
	
	@SuppressWarnings("unchecked")
	public void toJsonBeverage() {
		// read the json file
		JSONParser parser = new JSONParser();
		JSONObject j_file = new JSONObject();
		
		File myfile = new File("Beverages.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			j_file = (JSONObject) parser.parse(new FileReader("./Beverages.json"));
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}		
		
		j_file.put(this.getID().toString(), this.getAttributes());
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Beverages.json")) {
			file.write(j_file.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
