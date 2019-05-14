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

public class Employee {
	private String name;
	private String surname;
	private Integer ID;
	private PersonalAccount account;
	
	@SuppressWarnings("unchecked")
	public Employee(String name, String surname, Integer ID) {
		this.name=name;
		this.surname=surname;
		this.ID=ID;
		this.account= new PersonalAccount(0);
	}

	public List<String> getAttributes() {
		List<String> attributes = new ArrayList<String>();
		
		attributes.add(0, name);
		attributes.add(1, surname);
		attributes.add(2, ID.toString());
		attributes.add(3, account.getBalance().toString());
		
		return attributes;

	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public PersonalAccount getPersonalaccount() {
		return this.account;
	}
	
	public void setPersonalaccount(PersonalAccount account) {
		this.account=account;
	}
	
	public Integer getID() {
		return this.ID;
	}

	@SuppressWarnings("unchecked")
	public void toJsonEmployee() {
		// read the json file
		JSONParser parser = new JSONParser();
		JSONObject j_file = new JSONObject();
		
		File myfile = new File("Employees.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			j_file = (JSONObject) parser.parse(new FileReader("./Employees.json"));
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}		
		
		j_file.put(this.getID().toString(), this.getAttributes());
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Employees.json")) {
			file.write(j_file.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
