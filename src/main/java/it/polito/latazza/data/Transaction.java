package it.polito.latazza.data;


import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.NumberFormatException;

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
	
}
