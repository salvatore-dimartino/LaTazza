package it.polito.latazza.data;

import java.util.Date;

public class Recharge extends Transaction {
	
	private Integer amount;
	private Employee employee;

	public Recharge(int ID, Date date, Integer amount, Employee employee) {
		super(ID, date);
		this.amount=amount;
		this.employee=employee;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	// The string format for a recharge is "[datetime] RECHARGE [employee] [amount]".
	public String getString() {
		return this.getDate().toString() + " RECHARGE " + this.getEmployee().getName() + " " +
			   this.getEmployee().getSurname() + " " + this.amount.toString();
	}

}
