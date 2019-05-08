package it.polito.latazza.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class DataImpl implements DataInterface {
    
    private static Map<Integer, Employee> Employees = new HashMap<>();
    private static Map<Integer, Beverage> Beverages = new HashMap<>();
    private static Map<Integer, Transaction> Transactions = new HashMap<>();
    private LaTazzaAccount account = new LaTazzaAccount();

	@Override
	public Integer sellCapsules(Integer employeeId, Integer beverageId, Integer numberOfCapsules, Boolean fromAccount)
			throws EmployeeException, BeverageException, NotEnoughCapsules {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sellCapsulesToVisitor(Integer beverageId, Integer numberOfCapsules)
			throws BeverageException, NotEnoughCapsules {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer rechargeAccount(Integer id, Integer amountInCents) throws EmployeeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void buyBoxes(Integer beverageId, Integer boxQuantity) throws BeverageException, NotEnoughBalance {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getEmployeeReport(Integer employeeId, Date startDate, Date endDate)
			throws EmployeeException, DateException {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}

	@Override
	public List<String> getReport(Date startDate, Date endDate) throws DateException {
		
		if(startDate == null || endDate == null) {
			throw new DateException();
		}
		
		List<String> l = new ArrayList<String>();
		Transactions.forEach((k, v) -> {
			if(v.getDate().after(startDate) && v.getDate().before(endDate))
				l.add(v.getString());
			});
		
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public Integer createBeverage(String name, Integer capsulesPerBox, Integer boxPrice) throws BeverageException {
		
		if(name == null || capsulesPerBox == 0 || boxPrice == 0) {
			throw new BeverageException();
		} else {
		Beverage b = new Beverage(Beverages.size(), name, boxPrice, capsulesPerBox, 0);
		Beverages.put(Beverages.size(), b);
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateBeverage(Integer id, String name, Integer capsulesPerBox, Integer boxPrice)
			throws BeverageException {
		
		if (Beverages.get(id) == null) {
			throw new BeverageException();
		}else{
		Beverages.get(id).setName(name);
		Beverages.get(id).setPrice(boxPrice);
		Beverages.get(id).setQuantityPerBox(capsulesPerBox);
		}
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public String getBeverageName(Integer id) throws BeverageException {
		
		if (Beverages.get(id) == null) {
			throw new BeverageException();
		}
		// TODO Auto-generated method stub
		return Beverages.get(id).getName();
	}

	@Override
	public Integer getBeverageCapsulesPerBox(Integer id) throws BeverageException {
		
		if (Beverages.get(id) == null) {
			throw new BeverageException();
		}
		
		// TODO Auto-generated method stub
		return Beverages.get(id).getQuantityPerBox();
	}

	@Override
	public Integer getBeverageBoxPrice(Integer id) throws BeverageException {
		

		if (Beverages.get(id) == null) {
			throw new BeverageException();
		}
		
		// TODO Auto-generated method stub
		return Beverages.get(id).getPrice();
	}

	@Override
	public List<Integer> getBeveragesId() {
		List<Integer> id = new ArrayList<Integer>();
		Beverages.forEach((k, v) -> {id.add(k);});
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Map<Integer, String> getBeverages() {
		
		HashMap<Integer, String> b = new HashMap<Integer, String>();
		Beverages.forEach((k, v) -> {b.put(k, v.getName());});
		// TODO Auto-generated method stub
		return b;
	}

	@Override
	public Integer getBeverageCapsules(Integer id) throws BeverageException {
		
		if (Beverages.get(id) == null) {
			throw new BeverageException();
		}
		// TODO Auto-generated method stub
		return Beverages.get(id).getAvailableQuantity();
	}

	@Override
	public Integer createEmployee(String name, String surname) throws EmployeeException {
		
		if(name == null || surname == null) {
			throw new EmployeeException();
		} else {
		Employee e = new Employee(name, surname, Employees.size());
		Employees.put(Employees.size(), e);
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateEmployee(Integer id, String name, String surname) throws EmployeeException {
		if(Employees.get(id) == null) {
			throw new EmployeeException();
		} else {
			Employees.get(id).setName(name);
			Employees.get(id).setSurname(surname);
		}
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public String getEmployeeName(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getEmployeeSurname(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Integer getEmployeeBalance(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getEmployeesId() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>();
	}

	@Override
	public Map<Integer, String> getEmployees() {
		// TODO Auto-generated method stub
		return new HashMap<Integer, String>();
	}

	@Override
	public Integer getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
