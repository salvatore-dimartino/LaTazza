package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

import it.polito.latazza.exceptions.BeverageException;

public class RechargeTest extends junit.framework.TestCase {
	
	Recharge r1, r2;
	Date d1;
	Employee e1, e2;
	
	public RechargeTest() throws Exception {
		setUp();
	}
	
	@Test
	protected void setUp() throws Exception {
		
		d1 = new Date();
		e1 = new Employee("Ludito", "Arduca", 0);
		e2 = new Employee("Moriano", "Maurizio", 1);
		r1 = new Recharge(0, d1, 100, e1);
		r2 = new Recharge(1, d1, 200, e2);
			 
	}
	
	@Test 
	public void testRecharge() {
		Recharge r3;
		
		try {
			r3 = new Recharge(2, d1, 300, e1);				
		}catch(Exception e){
			fail();	
		}
		
		assertThrows(Exception.class, () -> {Recharge r4 = new Recharge(3, d1, -200, e2);});
		
		return;
	}
	
	@Test
	public void testSetAmount() {
		
		try {
			r1.setAmount(100);
		}catch(Exception e) {
			fail();
		}
		assertThrows(Exception.class, () -> r1.setAmount(-100));
		
		return;
	}
	
	@Test
	public void testGetAmount() {
		assertTrue(r2.getAmount() == 200);
		return;
	}

}
