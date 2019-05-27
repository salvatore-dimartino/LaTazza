package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;

import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class DataImplTest extends junit.framework.TestCase {
	
	DataImpl data1;
	Employee e1, e2, e3, e4;
	Beverage b1, b2;
	
	public DataImplTest() throws BeverageException, EmployeeException, NotEnoughBalance {
		setUp();
	}
	
	protected void setUp() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		e1 = new Employee("Gianni", "Morandi", 0); // Contained
		e2 = new Employee("Pippo", "Baudo", 1); // Contained
		e3 = new Employee("Ludito", "Arduca", 2);
		e4 = new Employee("Moriano", "Maurizio", 3);
		
		b1 = new Beverage(0, "Caffe", 3000, 10, 0); // Contained
		b2 = new Beverage(1, "The", 5000, 8, 0);
		
		data1 = new DataImpl();
		data1.createEmployee("Gianni", "Morandi"); //0
		data1.createEmployee("Pippo", "Baudo"); //1
		data1.createBeverage("Caffe", 10, 3000);
		data1.rechargeAccount(0, 20000);
		data1.buyBoxes(0, 3);
		
		return;
	}
	
	@Test
	public void testDataImpl() {
		
		return;
	}
	
	@Test
	public void testSellCapsules() throws EmployeeException, BeverageException, NotEnoughCapsules, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		assertEquals(data1.sellCapsules(0, 0, 30, true).intValue(), (20000 - 3000*3));
		data1.reset();
		this.setUp();
		assertThrows(NotEnoughCapsules.class, () -> data1.sellCapsules(0, 0, 40, true));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.sellCapsules(null, 0, 10, true));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.sellCapsules(4, 0, 10, true));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.sellCapsules(0, 1, 10, true));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.sellCapsules(1, null, 40, true));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.sellCapsules(null, 1, 10, true));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.sellCapsules(4, null, 40, true));
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testSellCapsulesToVisitor() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		try{
			data1.sellCapsulesToVisitor(0, 10);
			}
		catch(BeverageException be) {
			fail();
		} catch (NotEnoughCapsules ce) {
			fail();
		}
		data1.reset();
		this.setUp();
		assertThrows(NotEnoughCapsules.class, () -> data1.sellCapsulesToVisitor(0, 40));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.sellCapsulesToVisitor(3, 10));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.sellCapsulesToVisitor(null, 40));
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testRechargeAccount() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp(); //Personal is € 200 because you have not sold to the employee yet
		assertEquals(data1.rechargeAccount(0, -10000).intValue(), 20000);
		data1.reset();
		this.setUp();
		assertTrue(data1.rechargeAccount(0, 10000) == 30000);
		data1.reset();
		this.setUp(); //--> Should be EMPLOYEEEXCPETION
		assertThrows(EmployeeException.class, () -> data1.rechargeAccount(3, -10000));
		data1.reset();
		this.setUp(); //--> Should be EMPLOYEEEXCPETION
		assertThrows(EmployeeException.class, () -> data1.rechargeAccount(4, 30000));
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testBuyBoxes() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp(); 
		assertThrows(BeverageException.class, () -> data1.buyBoxes(0, -1));
		data1.reset();
		this.setUp();
		try {
			data1.buyBoxes(0, 1);
		}catch(BeverageException be) {
			fail();
		}
		data1.reset();
		this.setUp(); 
		assertThrows(BeverageException.class, () -> data1.buyBoxes(null, -1));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.buyBoxes(null, 1));
		
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetEmployeeReport() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		
		Date d1 = new Date(2010, 1, 1);
		Date d2 = new Date(2020, 1, 1);
		try{
			data1.getEmployeeReport(0, d1, d2);
		} catch (EmployeeException ee) {
			fail();
		}
		catch (DateException de) {
			fail();
		}
		
		data1.reset();
		this.setUp();
		assertThrows(DateException.class, () -> data1.getEmployeeReport(0, d2, d1));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.getEmployeeReport(5, d2, d1));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.getEmployeeReport(null, d2, d1));
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetReport() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		
		Date d1 = new Date(2010, 1, 1);
		Date d2 = new Date(2020, 1, 1);
		try{
			data1.getReport(d1, d2);
		} catch (DateException de) {
			fail();
		}
		
		data1.reset();
		this.setUp();
		assertThrows(DateException.class, () -> data1.getReport(d2, d1));
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testCreateBeverage() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("@cqua", -10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("@cqua", -10, 8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("@cqua", 10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("@cqua", 10, 8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("Acqua", -10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("Acqua", -10, 8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.createBeverage("Acqua", 10, -8));
		data1.reset();
		this.setUp();
		assertEquals(data1.createBeverage("Acqua", 10, 8).intValue(), 1);
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testUpdateBeverage() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", -10, -8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", -10, 8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", 10, -8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", 10, 8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", -10, -8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", -10, 8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", 10, -8));
		data1.reset();
		this.setUp();
		data1.createBeverage("Acqua", 10, 8);
		try{
			data1.updateBeverage(1, "Acqua", 10, 8);
		}catch(BeverageException be) {
			fail();
		}
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", -10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", -10, 8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", 10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "@cqua", 10, 8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", -10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", -10, 8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", 10, -8));
		data1.reset();
		this.setUp();
		assertThrows(BeverageException.class, () -> data1.updateBeverage(1, "Acqua", 10, -8));
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetBeverageName() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetBeverageCapsulesPerBox() {
		// TODO Auto-generated method stub
		return;
	}

    // changed from void to int to overcome reference issues
	@Test
	public int testGetBeverageBoxPrice() {
		// TODO Auto-generated method stub
		return 0;
	} 

	@Test
	public int testGetBeveragesId() {
		// TODO Auto-generated method stub
		return 0;
	} 

	@Test
	public void testGetBeverages() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetBeverageCapsules() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testCreateEmployee() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.createEmployee("Ferdinan0", "Be11o"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.createEmployee("Ferdinan0", "Bello"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.createEmployee("Ferdinano", "Be11o"));
		data1.reset();
		this.setUp();
		try {
			data1.createEmployee("Ferdinano", "Bello");
		} catch (EmployeeException e) { 
			fail();
		}
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testUpdateEmployee() throws EmployeeException, BeverageException, NotEnoughBalance {
		
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(1, "Ferdinan0", "Be11o"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(1, "Ferdinan0", "Bello"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(1, "Ferdinano", "Be11o"));
		data1.reset();
		this.setUp();
		try {
			data1.updateEmployee(1, "Ferdinano", "Bello");
		} catch (EmployeeException e) { 
			fail();
		}
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(4, "Ferdinan0", "Be11o"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(3, "Ferdinan0", "Bello"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(null, "Ferdinano", "Be11o"));
		data1.reset();
		this.setUp();
		assertThrows(EmployeeException.class, () -> data1.updateEmployee(null, "Ferdinano", "Bello"));
		
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetEmployeeName() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetEmployeeSurname() {
		// TODO Auto-generated method stub
		return ;
	}

	@Test
	public void testGetEmployeeBalance() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetEmployeesId() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetEmployees() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetBalance() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testReset() {
		// TODO Auto-generated method stub
		
	}


}
