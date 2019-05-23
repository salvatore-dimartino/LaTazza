package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.List;

import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class APITest extends junit.framework.TestCase{
	
	DataImpl data1 =new DataImpl();
	Employee e1, e2, e3, e4;
	Beverage b1, b2;
	
	public APITest() throws BeverageException, EmployeeException, NotEnoughBalance {
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
	public void Scenario1() throws EmployeeException, BeverageException, NotEnoughBalance, NotEnoughCapsules {
		data1.reset();
		this.setUp();
		try {
			int a = data1.sellCapsules(0,0,1,true);
			assertEquals(19700,a);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario2() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			int a = data1.sellCapsules(1,0,1,true);
			assertEquals(-300,a);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario3() throws EmployeeException, BeverageException, NotEnoughBalance, NotEnoughCapsules {
		data1.reset();
		this.setUp();
		try {
			int a = data1.sellCapsules(0,0,10,true);
			assertEquals(17000,a);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario4() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			int a = data1.sellCapsules(1,0,10,true);
			assertEquals(-3000,a);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario5() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			data1.sellCapsulesToVisitor(0, 10);
		} catch(Exception e) {
			fail();
		}
		
	}
	
	@Test
	public void Scenario6() throws EmployeeException, BeverageException, NotEnoughBalance, NotEnoughCapsules {
		data1.reset();
		this.setUp();
		try {
			int a = data1.sellCapsules(0,0,10,false);
			assertEquals(20000,a);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario7() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			data1.buyBoxes(0, 2);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario8() throws EmployeeException, BeverageException, NotEnoughBalance{
		data1.reset();
		this.setUp();
        Date start =  new Date(110, 1, 1);
        Date end = new Date(130, 1, 1);
		try {
			List<String> rep=data1.getEmployeeReport(0,start,end);
			assertEquals(1,rep.size());
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void Scenario9() throws EmployeeException, BeverageException, NotEnoughBalance{
		data1.reset();
		this.setUp();
        Date start =  new Date(110, 1, 1);
        Date end = new Date(130, 1, 1);
		try {
			List<String> rep=data1.getReport(start,end);
			assertEquals(2,rep.size());
		} catch(Exception e) {
			fail();
		}
	}
	
	public void Scenario10() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			int id=data1.createEmployee("Pampiero","Cambodi");
			assertEquals(2,id);
			assertEquals("Pampiero",data1.getEmployeeName(2));
			assertEquals("Cambodi",data1.getEmployeeSurname(2));
		} catch(Exception e) {
			fail();
		}
	}
	
	public void Scenario11() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			data1.updateEmployee(0,"Pampiero","Cambodi");
			assertEquals("Pampiero",data1.getEmployeeName(0));
			assertEquals("Cambodi",data1.getEmployeeSurname(0));
		} catch(Exception e) {
			fail();
		}
	}
	
	public void Scenario12() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			int id=data1.createBeverage("Quercola",10,1000);
			assertEquals(1,id);
			assertEquals("Quercola",data1.getBeverageName(1));
			assertEquals(10,data1.getBeverageCapsulesPerBox(1).intValue());
			assertEquals(1000,data1.getBeverageBoxPrice(1).intValue());
		} catch(Exception e) {
			fail();
		}
	}
	
	public void Scenario13() throws EmployeeException, BeverageException, NotEnoughBalance {
		data1.reset();
		this.setUp();
		try {
			data1.updateBeverage(0,"Quercola",10,1000);
			assertEquals("Quercola",data1.getBeverageName(0));
			assertEquals(10,data1.getBeverageCapsulesPerBox(0).intValue());
			assertEquals(1000,data1.getBeverageBoxPrice(0).intValue());
		} catch(Exception e) {
			fail();
		}
	}
}
