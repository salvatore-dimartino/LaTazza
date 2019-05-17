package it.polito.latazza.data;

import org.json.simple.JSONArray;
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

	public Recharge(int ID, Date date, Integer amount, Employee employee) throws Exception {
		
		super(ID, date);
		
		if(amount > 0)
			this.amount=amount;
		else
			throw new Exception();
		
		this.employee=employee;
	
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) throws Exception {
		
		if(amount > 0)
			this.amount = amount;
		else
			throw new Exception();
		
		
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	// The string format for a recharge is "[datetime] RECHARGE [employee] [amount]".
	public String getString() {
		return super.getString() + " RECHARGE " + this.getEmployee().getName() + " " +
			   this.getEmployee().getSurname() + " " + this.amount.toString();
	}
	

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
		JSONArray j_file = new JSONArray();
		
		File myfile = new File("Transactions.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		try {
			j_file = (JSONArray) parser.parse(new FileReader("./Transactions.json"));
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
		}	
		
		JSONObject rechargeObject = new JSONObject();
		rechargeObject.put("ID", this.getID().toString());
		rechargeObject.put("List_Attributes", this.getAttributes());
		rechargeObject.put("Type", "RECHARGE");
		j_file.add(rechargeObject);
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Transactions.json")) {
			file.write(j_file.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
	    }

	}


}
