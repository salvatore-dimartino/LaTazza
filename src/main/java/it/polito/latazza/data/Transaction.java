package it.polito.latazza.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{
	
	//default serialVersion id
    private static final long serialVersionUID = 1L;
    
	private Integer ID;	private Date date; 
	
	private static final String filepath=(new File("transactions.txt")).getAbsolutePath();
	
	public Transaction(int ID, Date date) {
		this.ID = ID;
		this.date = date;
		
		this.WriteObjectToFile(this);
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

	public String getString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void WriteObjectToFile(Object serObj) {
		 
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
