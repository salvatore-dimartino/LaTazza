package it.polito.latazza.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recharge extends Transaction {
	
	private Integer amount;
	private Employee employee;

	public Recharge(int ID, Date date, Integer amount, Employee employee) {
		
		super(ID, date);
		this.amount=amount;
		this.employee=employee;
	
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	// The string format for a recharge is "[datetime] RECHARGE [employee] [amount]".
	public String getString() {
		return this.getDate().toString() + " RECHARGE " + this.getEmployee().getName() + " " +
			   this.getEmployee().getSurname() + " " + this.amount.toString();
	}
	

	@Override
	public List<String> getAttributes() {
		
		List<String> att = new ArrayList<String>();
		
		att.add(this.getDate().toString());
		att.add(this.amount.toString());
		att.add(this.employee.getID().toString());
		
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
