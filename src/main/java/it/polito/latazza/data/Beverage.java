package it.polito.latazza.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polito.latazza.exceptions.BeverageException;

public class Beverage {
	
	private Integer ID;
	private String name;
	private Integer price;
	private Integer quantityPerBox;
	private Integer availableQuantity;
	private Integer oldPrice;
	private Integer oldQuantityPerBox;
	private Integer oldAvailableQuantity;
	
	public Beverage(Integer ID, String name, Integer price, Integer quantityPerBox, Integer availableQuantity)  throws BeverageException {
		
	if(ID >= 0)
			this.ID = ID;
		else
			throw new BeverageException();
		
		Pattern p = Pattern.compile("[A-Za-zéèòùì][A-Za-zéèòùì\']*([ ][A-Za-zéèòùì\'][A-Za-zéèòùì]*)*");
		Matcher m = p.matcher(name);
		boolean t = m.matches();
		if(t) {
			this.name = name;
		} else {
			throw new BeverageException();
		}
		
		if(price >= 0)
			this.price = price;
		else
			throw new BeverageException();
		
		if(quantityPerBox >= 0)
			this.quantityPerBox = quantityPerBox;
		else
			throw new BeverageException();
		
		if(availableQuantity >= 0)
			this.availableQuantity = availableQuantity;
		else
			throw new BeverageException();
		
		this.oldPrice=-1;
		this.oldQuantityPerBox=-1;
		this.oldAvailableQuantity=-1;
	
	}

	public List<String> getAttributes(){
		List<String> attributes = new ArrayList<String>();
		
		attributes.add(name);
		attributes.add(price.toString());
		attributes.add(quantityPerBox.toString());
		attributes.add(availableQuantity.toString());
		attributes.add(oldPrice.toString());
		attributes.add(oldQuantityPerBox.toString());
		attributes.add(oldAvailableQuantity.toString());
		
		return attributes;
	}
	

	public Integer getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Integer oldPrice) {
		this.oldPrice = oldPrice;
	}
	
	public Integer getOldQuantityPerBox() {
		return oldQuantityPerBox;
	}

	public void setOldQuantityPerBox(Integer oldQuantityPerBox) {
		this.oldQuantityPerBox = oldQuantityPerBox;
	}

	public Integer getOldAvailableQuantity() {
		return oldAvailableQuantity;
	}

	public void setOldAvailableQuantity(Integer oldAvailableQuantity) {
		this.oldAvailableQuantity = oldAvailableQuantity;
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

	public void setName(String name) throws BeverageException {
		
		Pattern p = Pattern.compile("[A-Za-zéèòùì][A-Za-zéèòùì\']*([ ][A-Za-zéèòùì\'][A-Za-zéèòùì]*)*");
		Matcher m = p.matcher(name);
		boolean t = m.matches();
		if(t) {
			this.name = name;
		} else {
			throw new BeverageException();
		}
		
		return;
	}

	public void setPrice(Integer price) throws BeverageException {
		
		if(price > 0)
			this.price = price;
		else
			throw new BeverageException();
		
		return;
	}

	public void setQuantityPerBox(Integer quantityPerBox) throws BeverageException {
		if(quantityPerBox > 0)
			this.quantityPerBox = quantityPerBox;
		else
			throw new BeverageException();
		
		return;
	}

	public void setAvailableQuantity(Integer availableQuantity) throws BeverageException {
		
		if(availableQuantity >= 0)
			this.availableQuantity = availableQuantity;
		else
			throw new BeverageException();
		
		return;
	}
	
	@SuppressWarnings("unchecked")
	public void toJsonBeverage() {
		// read the json file
		JSONParser parser = new JSONParser();
		JSONArray j_file = new JSONArray();
		
		File myfile = new File("Beverages.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
		}
		
		try {
			j_file = (JSONArray) parser.parse(new FileReader("./Beverages.json"));
						
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
		} catch (ParseException e) {
		}		
		
		JSONObject beverageObject = new JSONObject();
		beverageObject.put("ID", this.getID().toString());
		beverageObject.put("List_Attributes", this.getAttributes());
		j_file.add(beverageObject);
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Beverages.json")) {
			file.write(j_file.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void updateJsonBeverage() {
		// read the json file
		JSONParser parser = new JSONParser();
		JSONArray j_file = new JSONArray();
				
		File myfile = new File("Beverages.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
		}
				
		try {
			j_file = (JSONArray) parser.parse(new FileReader("./Beverages.json"));
								
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
		} catch (ParseException e) {
		}	
		
		JSONObject beverageObject = new JSONObject();
		beverageObject.put("ID", this.getID().toString());
		beverageObject.put("List_Attributes", this.getAttributes());
		
		//update beverage
		j_file.set(this.ID, beverageObject);
		
		// write the json object to the file
				try (FileWriter file = new FileWriter("./Beverages.json")) {
					file.write(j_file.toJSONString());
					file.flush();
					file.close();
				} catch (IOException e) {
				}
		
	}
}
