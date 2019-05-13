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

public class Transaction {
	
	private Integer ID;
	private Date date; 
	
	public Transaction(int ID, Date date) {
		
		this.ID = ID;
		this.date = date;
		
	}

	public Integer getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getAttributes() {
		
		List<String> att = new ArrayList<String>();
		
		att.add(0, this.ID.toString());
		att.add(1, this.date.toString());
		
		return att;
	}
	
	@SuppressWarnings("unchecked")
	public void toJsonTransaction() {
		
		JSONParser parser = new JSONParser();
		JSONObject j_file = new JSONObject();
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
			// TODO Auto-generated catch block
			System.out.println("Parse Error\n");
			e1.printStackTrace();
		}	
		
		j_file.put(this.ID.toString(), this.getAttributes());
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./Transactions.json")) {
			file.write(j_file.toJSONString());
			file.flush();
					 
		} catch (IOException e) {
			e.printStackTrace();
	    }

	}

}
