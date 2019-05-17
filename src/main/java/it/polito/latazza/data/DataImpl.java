package it.polito.latazza.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

	public DataImpl() {
		//Import the data from the files, if the exist
		
		File fe = new File("Employees.json");
		if(fe.exists()) { 
			Employees = loadEmployees();
		}
		File fb = new File("Beverages.json");
		if(fb.exists()) { 
			Beverages = loadBeverages();
		}
		File t = new File("Transactions.json");
		if(t.exists()) { 
			Transactions = loadTransactions();
		}
		File lta = new File("LaTazzaAccount.json");
		if(lta.exists()) { 
			account = loadLaTazzaAccount();
		} 
	}

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
		
		// get the payment mode
		String payMode = new String();
		if(fromAccount) payMode="BALANCE";
		else payMode="CASH";
		
		if(!fromAccount)
		    account.setTotal(account.getTotal()+numberOfCapsules*beverage.getPrice()/beverage.getQuantityPerBox());
		
		// update the transactions
		Integer TID = Transactions.size()+1;
		Consumption consumption = new Consumption(TID, new Date(), numberOfCapsules, Beverages.get(beverageId), Employees.get(employeeId), payMode);
		Transactions.put(TID, consumption);
		
		consumption.toJsonTransaction();
		
		transaction.toJsonTransaction();
		
		// update personal account
		PersonalAccount P_account = employee.getPersonalaccount();
		if(fromAccount == true) {
			P_account.addTransaction(consumption);
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
		
		account.setTotal(account.getTotal()+numberOfCapsules*beverage.getPrice()/beverage.getQuantityPerBox());
		
		// update the transactions
		Integer TID = Transactions.size();
		Consumption consumption = new Consumption(TID, new Date(), numberOfCapsules, Beverages.get(beverageId), null, "VISITOR");
		Transactions.put(TID, consumption);
		
		consumption.toJsonTransaction();
		
		transaction.toJsonTransaction();
		
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
		
		recharge.toJsonTransaction();
		
		// update personal account
		PersonalAccount P_account = employee.getPersonalaccount();
		P_account.addTransaction(recharge);
		P_account.setBalance(P_account.getBalance()+amountInCents);
		account.setTotal(account.getTotal()+amountInCents);
		account.toJsonLaTazzaAccount();
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
		account.toJsonLaTazzaAccount();
		
		// update the transactions
		Integer TID = Transactions.size()+1;
		BoxPurchase boxpurchase= new BoxPurchase(TID, new Date(), boxQuantity, beverage);
		Transactions.put(TID, boxpurchase);
		
		boxpurchase.toJsonTransaction();
		
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
		List<String> Report= new ArrayList<String>();
		Transactions.forEach((k,v)->{
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
			
			b.toJsonBeverage();
		}
		// TODO Auto-generated method stub
		return b.getID();
	}

	@Override
	public void updateBeverage(Integer id, String name, Integer capsulesPerBox, Integer boxPrice)
			throws BeverageException {
		
		Beverage beverage = Beverages.get(id);
		
		if (beverage == null) {
			throw new BeverageException();
		}else{
			beverage.setName(name);
			beverage.setPrice(boxPrice);
			beverage.setQuantityPerBox(capsulesPerBox);
			
			beverage.toJsonBeverage();		
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
		e.toJsonEmployee();
		}
	
		return e.getID();
	}

	@Override
	public void updateEmployee(Integer id, String name, String surname) throws EmployeeException {
		if(Employees.get(id) == null) {
			throw new EmployeeException();
		} else {
			Employees.get(id).setName(name);
			Employees.get(id).setSurname(surname);
			Employees.get(id).toJsonEmployee();
		}
	
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
		
		try {
			new FileWriter("./Beverages.json").close();
			new FileWriter("./Employees.json").close();
			new FileWriter("./Transactions.json").close();
			new FileWriter("./LaTazzaAccount.json").close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@SuppressWarnings("unchecked")
	private static Map<Integer, Employee> loadEmployees(){
		Map<Integer, Employee> employees = new HashMap<>();
		
		// read the json file
		JSONParser parser = new JSONParser();
		Object j_obj = new Object();
		
		try {
			j_obj = parser.parse(new FileReader("./Employees.json"));
			
			JSONArray employeeList = (JSONArray) j_obj;
			
			//Iterate over employee array
			employeeList.forEach( emp -> {
				JSONObject employee = (JSONObject) emp;
				
				//Get employee ID
				String ID = (String) employee.get("ID"); 		
				
				//Get Attribute List
				List<String> attributes = (List<String>) employee.get("List_Attributes");
				
				//Get employee  name
		        String name = (String) attributes.get(0);
		         
		        //Get employee surname
		        String surname = (String) attributes.get(1);
		        
		        //Get personal account balance
		        String balance = (String) attributes.get(2);
		        
		        //Create the employee object to insert in the list, together with its own account
		        PersonalAccount account = new PersonalAccount(Integer.parseInt(balance));
		        
		        Employee e = new Employee(name, surname, Integer.parseInt(ID));
		        e.setPersonalaccount(account);
		        
		        employees.put(employees.size(), e);
		        
			});
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}
		
		return employees;
	}
	
	@SuppressWarnings("unchecked")
	private static Map<Integer, Beverage> loadBeverages(){
		Map<Integer, Beverage> beverages = new HashMap<>();
		
		// read the json file
		JSONParser parser = new JSONParser();
		Object j_obj = new Object();
		
		try {
			j_obj = parser.parse(new FileReader("./Beverages.json"));
			
			JSONArray beverageList = (JSONArray) j_obj;
			
			//Iterate over employee array
			beverageList.forEach( bev -> {
				JSONObject beverage = (JSONObject) bev;
				
				//Get employee ID
				String ID = (String) beverage.get("ID"); 		
				
				//Get Attribute List
				List<String> attributes = (List<String>) beverage.get("List_Attributes");
				
				//Get beverage  name
		        String name = (String) attributes.get(0);
		         
		        //Get beverage price
		        String price = (String) attributes.get(1);
		        
		        //Get beverage quantity per box
		        String qtyBox = (String) attributes.get(2);
		        
		        //Get beverage available quantity
		        String availQty = (String) attributes.get(3);
		        
		        Beverage b = new Beverage(Integer.parseInt(ID), name, Integer.parseInt(price), Integer.parseInt(qtyBox), Integer.parseInt(availQty));
		        
		        beverages.put(beverages.size(), b);
		        
			});
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}
		
		return beverages;
	}
	
	@SuppressWarnings("unchecked")
	private static Map<Integer, Transaction> loadTransactions(){
		Map<Integer, Transaction> transactions = new HashMap<>();
		
		// read the json file
		JSONParser parser = new JSONParser();
		Object j_obj = new Object();
		
		try {
			j_obj = parser.parse(new FileReader("./Transactions.json"));
			
			JSONArray transactionList = (JSONArray) j_obj;
			
			//Iterate over employee array
			transactionList.forEach( trans -> {
				JSONObject transaction = (JSONObject) trans;
				
				//Get transaction ID
				String ID = (String) transaction.get("ID"); 		
				
				//Get Attribute List
				List<String> attributes = (List<String>) transaction.get("List_Attributes");
				
				// Get if the transaction is a BoxPurchase, a Consumption or a Recharge
				String transactionType = (String) transaction.get("Type");
				
				//Get the transaction date
				DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss");
				
				try {
					Date date = dateFormat.parse(attributes.get(0));
					
					if(transactionType.compareTo("BOXPURCHASE") == 0) {
						//Get quantity
				        Integer qty = Integer.parseInt(attributes.get(1));
				        //Get beverage
				        Beverage bev = Beverages.get(Integer.parseInt(attributes.get(2)));
				        
				        BoxPurchase bp = new BoxPurchase(Integer.parseInt(ID), date, qty, bev);
				        Transactions.put(transactions.size(), bp);
					}
					else if(transactionType.compareTo("CONSUMPTION") == 0) {
						//Get quantity
						Integer qty = Integer.parseInt(attributes.get(1));
						
						//Get beverage
						Beverage bev = Beverages.get(Integer.parseInt(attributes.get(2)));
						
						//Get employee
						Employee emp;
						if(attributes.get(3) != null)
						emp = Employees.get(Integer.parseInt(attributes.get(3)));
						else emp = null;
						
						//Get type
						String type = attributes.get(4);
						
						Consumption cons = new Consumption(Integer.parseInt(ID), date, qty, bev, emp, type);
						Transactions.put(transactions.size(), cons);
					}
					else if(transactionType.compareTo("RECHARGE") == 0) {
						//Get Amount
						Integer amount = Integer.parseInt(attributes.get(1));
						
						//Get Employee
						Employee emp = Employees.get(Integer.parseInt(attributes.get(2)));
						
						Recharge rec = new Recharge(Integer.parseInt(ID), date, amount, emp);
						Transactions.put(transactions.size(), rec);
					}
					
				//} catch (java.text.ParseException e) {
				}   catch (Exception e) {
					e.printStackTrace();
				}	
				
			});
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}
		
		return transactions;
	}
	
	private static LaTazzaAccount loadLaTazzaAccount(){
		Integer balance = 0;
		
		// read the json file
		JSONParser parser = new JSONParser();
		Object j_obj = new Object();
		
		try {
			j_obj = parser.parse(new FileReader("./LaTazzaAccount.json"));
			
			JSONObject j_account = (JSONObject) j_obj;
			
			balance = Integer.parseInt((String) j_account.get("Balance"));
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}
		
		return new LaTazzaAccount(balance);
	}
	
}