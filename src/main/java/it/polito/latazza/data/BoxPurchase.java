package it.polito.latazza.data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BoxPurchase extends Transaction {
	
	Integer quantity;
	Beverage beverage;
	
	public BoxPurchase(Integer ID, Date date, Integer quantity, Beverage beverage) throws Exception {
		
		super(ID, date);
		if(quantity > 0 )
			this.quantity = quantity;
		else throw new Exception();
		
		this.beverage = beverage;

	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) throws Exception {
		if(quantity > 0)
			this.quantity = quantity;
		else throw new Exception();
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getString() {
		return  super.getString() + " BUY " + beverage.getName() + " " + quantity.toString();
	}
	
	public List<String> getAttributes() {
		
		List<String> att = new ArrayList<String>();
		
		att.add(this.getDate().toString());
		att.add(this.quantity.toString());
		att.add(this.beverage.getID().toString());
		
		return att;
	}
	
	@SuppressWarnings("unchecked")
	public void toJsonTransaction() {
		
		JSONParser parser = new JSONParser();
		JSONArray j_file = new JSONArray();
		
		File myfile = new File("Transactions.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
		}
		
		try {
			j_file = (JSONArray) parser.parse(new FileReader("./Transactions.json"));
						
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
		} catch (ParseException e) {
		}	
		
		JSONObject boxpurchaseObject = new JSONObject();
		boxpurchaseObject.put("ID", this.getID().toString());
		boxpurchaseObject.put("List_Attributes", this.getAttributes());
		boxpurchaseObject.put("Type", "BOXPURCHASE");
		j_file.add(boxpurchaseObject);
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Transactions.json")) {
			file.write(j_file.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
	    }

	}


	
}