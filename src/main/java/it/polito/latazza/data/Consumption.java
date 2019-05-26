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



public class Consumption extends Transaction { 
	
	private Integer quantity;
	private Beverage beverage;
	private Employee employee;
	private String type;
	
	public Consumption(Integer ID, Date date, Integer quantity, Beverage beverage, Employee employee, String type) throws Exception {
		
		super(ID, date);
		if(quantity > 0)
			this.quantity = quantity;
		else throw new Exception();
		
		this.beverage = beverage;
		this.employee = employee;
		this.type = type;
		
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
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getString() {
		
		if(type.equals("CASH"))
			return super.getString() + " " + type + " " + employee.getName() + " " + beverage.getName() + " " +  quantity.toString(); 
		if(type.equals("BALANCE"))
			return super.getString() + " " + type + " " + employee.getName() + " " + beverage.getName() + " " + quantity.toString(); 
		if(type.equals("VISITOR"))
			return super.getString() + " " + type + " " + beverage.getName() + " " + quantity.toString();
		
		return ""; 
	
	}
	
	public List<String> getAttributes() {
		
		List<String> att = new ArrayList<String>();
		
		att.add(this.getDate().toString());
		att.add(this.quantity.toString());
		att.add(this.beverage.getID().toString());
		if(this.employee != null) att.add(this.employee.getID().toString());
		else att.add(null);
		att.add(this.type);
		
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
		
		JSONObject consumptionObject = new JSONObject();
		consumptionObject.put("ID", this.getID().toString());
		consumptionObject.put("List_Attributes", this.getAttributes());
		consumptionObject.put("Type", "CONSUMPTION");
		j_file.add(consumptionObject);
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Transactions.json")) {
			file.write(j_file.toJSONString());
			file.flush();
			file.close(); 
		} catch (IOException e) {
	    }

	}


	
}

