package it.polito.latazza.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable{
	
	//default serialVersion id
    private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private Integer ID;
	private PersonalAccount account;
	
	private static final String filepath=(new File("beverages.txt")).getAbsolutePath();
	
	public Employee(String name, String surname, Integer ID) {
		this.name=name;
		this.surname=surname;
		this.ID=ID;
		this.account= new PersonalAccount(0);
		
		this.WriteObjectToFile(this);
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
