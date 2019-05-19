package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.NotEnoughBalance;

public class LaTazzaAccountTest extends junit.framework.TestCase {

	LaTazzaAccount l1, l2, l3, l4;
	
	public LaTazzaAccountTest() throws NotEnoughBalance {
		setUp();
	}
	
	protected void setUp() throws NotEnoughBalance {
		
		l1 = new LaTazzaAccount(0);
		l2 = new LaTazzaAccount(1000);
			 
	}
	
	@SuppressWarnings("unused")
	@Test
	public void LaTazzaAccount() throws NotEnoughBalance {
		
		LaTazzaAccount l3;
			
		try{
			l3 = new LaTazzaAccount(1);
		}catch(Exception e) {
			fail();
		}
		
		assertThrows(NotEnoughBalance.class, () -> {LaTazzaAccount p4 = new LaTazzaAccount(-1);});

		return;
	}
	
	@Test
	public void testSetTotal() {

		try{
			l1.setTotal(2500);
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(NotEnoughBalance.class, () -> l1.setTotal(-1000));
		return;
	}
	
	@Test
	public void testGetTotal() {
		assertTrue(l1.getTotal().equals(0));
		return;
	}
}
