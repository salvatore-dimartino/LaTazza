package it.polito.latazza.data;

public class Employee {
	private String name;
	private String surname;
	private Integer ID;
	private PersonalAccount account;
	
	public Employee(String name, String surname, Integer ID) {
		this.name=name;
		this.surname=surname;
		this.ID=ID;
		this.account= new PersonalAccount(0);
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
}
