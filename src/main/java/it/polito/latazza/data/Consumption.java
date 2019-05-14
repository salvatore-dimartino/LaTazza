package it.polito.latazza.data;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Consumption extends Transaction { 
	
	private Integer quantity;
	private Beverage beverage;
	private Employee employee;
	private String type;
	
	
	
	@SuppressWarnings("unchecked")
	public Consumption(Integer ID, Date date, Integer quantity, Beverage beverage, Employee employee, String type) {
		
		super(ID, date);
		this.quantity = quantity;
		this.beverage = beverage;
		this.employee = employee;
		this.type = type;

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
			return this.getDate().toString() + " " + type + " " + employee.getName() + " " + beverage.getName() + " " +  beverage.getQuantityPerBox().toString(); 
		if(type.equals("BALANCE"))
			return this.getDate().toString() + " " + type + " " + employee.getName() + " " + beverage.getName() + " " + beverage.getQuantityPerBox().toString(); 
		if(type.equals("VISITOR"))
			return this.getDate().toString() + " " + type + " " + beverage.getName() + " " + beverage.getQuantityPerBox().toString();
		
		return ""; 
	
	}
	
	@Override
	public List<String> getAttributes() {
		
		List<String> att = new ArrayList<String>();
		
		att.add(super.getID().toString());
		att.add(super.getDate().toString());
		att.add(this.quantity.toString());
		att.addAll(this.beverage.getAttributes());
		att.addAll(this.employee.getAttributes());
		att.add(this.type);
		
		return att;
	}
	
	@SuppressWarnings("unchecked")
	public void toJsonTransaction() {
		
		JSONParser parser = new JSONParser();
		JSONObject j_file = new JSONObject();
		
		File myfile = new File("Transactions.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			j_file = (JSONObject) parser.parse(new FileReader("./Transactions.json"));
						
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("file not found\n");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("IO Error\n");
			e1.printStackTrace();
		} catch (ParseException e1) {
		}	
		
		j_file.put(this.getID().toString(), this.getAttributes());
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Transactions.json")) {
			file.write(j_file.toJSONString());
			file.flush();
					 
		} catch (IOException e) {
			e.printStackTrace();
	    }

	}


	
}
