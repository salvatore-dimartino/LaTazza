package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
		assertTrue(data1.sellCapsules(0, 0, 30, true) == (20000 - 3000*3));
		data1.reset();
		this.setUp();
		assertTrue(data1.sellCapsules(0, 0, 0, true) == (20000));
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
		
		//assertThrows(BeverageException.class, () -> data1.sellCapsules(1, 3, 10, true));
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testSellCapsulesToVisitor() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testRechargeAccount() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testBuyBoxes() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetEmployeeReport() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetReport() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testCreateBeverage() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testUpdateBeverage() {
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

	@Test
	public void testGetBeverageBoxPrice() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testGetBeveragesId() {
		// TODO Auto-generated method stub
		return;
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
	public void testCreateEmployee() {
		// TODO Auto-generated method stub
		return;
	}

	@Test
	public void testUpdateEmployee() {
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
