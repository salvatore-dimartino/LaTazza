package it.polito.latazza.data;


import java.util.Date;

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
	    return String.valueOf(date.getYear()+1900)+"-"+String.valueOf(date.getMonth())+"-"+String.valueOf(date.getDate())+" "+String.valueOf(date.getHours())+":"+String.valueOf(date.getMinutes())+":"+String.valueOf(date.getSeconds());
	}
	
}