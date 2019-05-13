package it.polito.latazza.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class DataImpl implements DataInterface {
    
    private static Map<Integer, Employee> Employees = new HashMap<>();
    private static Map<Integer, Beverage> Beverages = new HashMap<>();
    private static Map<Integer, Transaction> Transactions = new HashMap<>();
    private LaTazzaAccount account = new LaTazzaAccount(0);

	@Override
	public Integer sellCapsules(Integer employeeId, Integer beverageId, Integer numberOfCapsules, Boolean fromAccount)
			throws EmployeeException, BeverageException, NotEnoughCapsules {
		
		// check employee existence
		Employee employee = Employees.get(employeeId);
		if(employee == null) throw new EmployeeException();
		
		// check beverage existence
		Beverage beverage = Beverages.get(beverageId);
		if(beverage == null) throw new BeverageException();
		
		// check availability
		Integer avail_qty = beverage.getAvailableQuantity();
		if(avail_qty < numberOfCapsules) throw new NotEnoughCapsules();
		
		// update the availability
		beverage.setAvailableQuantity(avail_qty-numberOfCapsules);
		
		// update the transactions
		Integer TID = Transactions.size()+1;
		Transaction transaction = new Transaction(TID, new Date());
		Transactions.put(TID, transaction);
		
		// update personal account
		PersonalAccount P_account = employee.getPersonalaccount();
		if(fromAccount == true) {
			P_account.addTransaction(transaction);
			P_account.setBalance(P_account.getBalance()-numberOfCapsules*beverage.getPrice()/beverage.getQuantityPerBox());
		}
		return P_account.getBalance();
	}

	@Override
	public void sellCapsulesToVisitor(Integer beverageId, Integer numberOfCapsules)
			throws BeverageException, NotEnoughCapsules {
		
		// check beverage existence
		Beverage beverage = Beverages.get(beverageId);
		if(beverage == null) throw new BeverageException();
		
		// check availability
		Integer avail_qty = beverage.getAvailableQuantity();
		if(avail_qty < numberOfCapsules) throw new NotEnoughCapsules();
				
		// update the availability
		beverage.setAvailableQuantity(avail_qty-numberOfCapsules);
		
		// update the transactions
		Integer TID = Transactions.size()+1;
		Transaction transaction = new Transaction(TID, new Date());
		Transactions.put(TID, transaction);
		
	}

	@Override
	public Integer rechargeAccount(Integer id, Integer amountInCents) throws EmployeeException {
		
		// check employee existence
		Employee employee = Employees.get(id);
		if(employee == null) throw new EmployeeException();
		
		// update the transactions
		Integer TID = Transactions.size()+1;
		Recharge recharge = new Recharge(TID, new Date(), amountInCents, employee);
		Transactions.put(TID, recharge);
		
		// update personal account
		PersonalAccount P_account = employee.getPersonalaccount();
		P_account.addTransaction(recharge);
		P_account.setBalance(P_account.getBalance()+amountInCents);
		account.setTotal(account.getTotal()+amountInCents);
		return P_account.getBalance();
	}

	@Override
	public void buyBoxes(Integer beverageId, Integer boxQuantity) throws BeverageException, NotEnoughBalance {
		
		// check beverage existence
		Beverage beverage = Beverages.get(beverageId);
		if(beverage == null) throw new BeverageException();
		
		// get total amount to pay
		Integer price = beverage.getPrice()*boxQuantity;
		
		// update the manager account
		if(account.getTotal() < price) throw new NotEnoughBalance();
		account.setTotal(account.getTotal()-price);
		
		// update the transactions
		Integer TID = Transactions.size()+1;
		BoxPurchase boxpurchase= new BoxPurchase(TID, new Date(), boxQuantity, beverage);
		Transactions.put(TID, boxpurchase);
		
		// update the availability
		beverage.setAvailableQuantity(beverage.getAvailableQuantity()+boxQuantity*beverage.getQuantityPerBox());
	}

	@Override
	public List<String> getEmployeeReport(Integer employeeId, Date startDate, Date endDate)
			throws EmployeeException, DateException {
		if(!Employees.keySet().contains(employeeId))
			throw new EmployeeException();
		if(startDate==null||endDate==null)
			throw new DateException();
		Map <Integer,Transaction> Transactions=Employees.get(employeeId).getPersonalaccount().getTransactions();
		List<String> Report= new ArrayList();
		Transactions.forEach((k,v)->{
			Date d=v.getDate();
			if(v.getDate().after(startDate) && v.getDate().before(endDate))
				Report.add(v.getString());
		});
		return Report;
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
		
		Beverage b = new Beverage(Beverages.size(), name, boxPrice, capsulesPerBox, 0);
		
		if(name == null || capsulesPerBox == 0 || boxPrice == 0) {
			throw new BeverageException();
		} else {
		Beverages.put(Beverages.size(), b);
		}
		// TODO Auto-generated method stub
		return b.getID();
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
		
		// update json object locally
		JsonObject json = Beverages.get(id).getJson();
		json.put("name", name);
		json.put("capsulesPerBox", capsulesPerBox.toString());
		json.put("boxPrice", boxPrice.toString());
		
		// update json file
		JSONParser parser = new JSONParser();
		JsonObject j_obj;
		try {
			j_obj = (JsonObject) parser.parse(new FileReader("c:\\my_json_file.json"));
			j_obj.put("name", name);
			try (FileWriter file = new FileWriter("c:\\my_json_file.json")) {
				 
	            file.write(j_obj.toJson());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		Employee e = new Employee(name, surname, Employees.size());
		
		if(name == null || surname == null) {
			throw new EmployeeException();
		} else {
		Employees.put(Employees.size(), e);
		}
		// TODO Auto-generated method stub
		return e.getID();
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
		if(!Employees.keySet().contains(id))
			throw new EmployeeException();
		return Employees.get(id).getName();
	}

	@Override
	public String getEmployeeSurname(Integer id) throws EmployeeException {
		if(!Employees.keySet().contains(id))
			throw new EmployeeException();
		return Employees.get(id).getSurname();
	}

	@Override
	public Integer getEmployeeBalance(Integer id) throws EmployeeException {
		if(!Employees.keySet().contains(id))
			throw new EmployeeException();
		return Employees.get(id).getPersonalaccount().getBalance();
	}

	@Override
	public List<Integer> getEmployeesId() {
		List<Integer> Emp=new ArrayList<>();
		Employees.forEach((k,v)->{
			Emp.add(k);
		});
		return Emp;
	}

	@Override
	public Map<Integer, String> getEmployees() {
		Map<Integer,String> Emp=new HashMap<>();
		Employees.forEach((k,v)->{
			Emp.put(k,v.getName()+" "+v.getSurname());
		});
		return Emp;
	}

	@Override
	public Integer getBalance() {
		return account.getTotal();
	}

	@Override
	public void reset() {
		Employees.clear();
		Beverages.clear();
		Transactions.clear();
		account.setTotal(0);
	}
	
}
