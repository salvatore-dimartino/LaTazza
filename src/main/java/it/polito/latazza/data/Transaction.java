package it.polito.latazza.data;

import java.util.Date;

public class Transaction {
	
	private Integer ID;	private Date date; 
	
	public Transaction(int ID, Date date) {
		this.ID = ID;
		this.date = date;
	}

	public int getID() {
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

}
