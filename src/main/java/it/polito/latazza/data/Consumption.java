package it.polito.latazza.data;
import java.util.Date;

public class Consumption extends Transaction { 
	
	private Integer quantity;
	private Beverage beverage;
	private Employee employee;
	private String type;
	
	public Consumption(Integer ID, Date date, Integer quantity, Beverage beverage, Employee employee, String type) {
		
		super(ID, date);
		this.quantity = quantity;
		this.beverage = beverage;
		this.employee = employee;
		this.type = type;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Beverage getBeverage() {
		return beverage;
	}
	
	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getString() {
		
		if(type.equals("CASH"))
			return this.getDate().toString() + " " + type + " " + employee.getName() + " " + beverage.getName() + " " +  beverage.getQuantityPerBox().toString(); 
		if(type.equals("BALANCE"))
			return this.getDate().toString() + " " + type + " " + employee.getName() + " " + beverage.getName() + " " + beverage.getQuantityPerBox().toString(); 
		if(type.equals("VISITOR"))
			return this.getDate().toString() + " " + type + " " + beverage.getName() + " " + beverage.getQuantityPerBox().toString();
		
		return ""; 
	
	}
	
}
