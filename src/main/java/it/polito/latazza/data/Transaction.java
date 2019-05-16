package it.polito.latazza.data;

import java.io.File;
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

import java.lang.NumberFormatException;

public class Transaction {
	
	private Integer ID;
	private Date date; 
	
	public Transaction(int ID, Date date) throws NumberFormatException{
	    
		if(ID >= 0)
			this.ID = ID;
		else
			throw new NumberFormatException();

		this.date = date;
		
	}

	public Integer getID() {
		return ID;
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
		
		att.add(this.date.toString());
		
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
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
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
