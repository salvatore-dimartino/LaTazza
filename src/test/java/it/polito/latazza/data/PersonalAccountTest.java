package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.NotEnoughBalance;

public class PersonalAccountTest extends junit.framework.TestCase {

	PersonalAccount p1, p2, p3, p4;
	
	public PersonalAccountTest() throws NotEnoughBalance {
		setUp();
	}
	
	protected void setUp() throws NotEnoughBalance {
		
		p1 = new PersonalAccount(0);
		p2 = new PersonalAccount(1000);
			 
	}
	
	@SuppressWarnings("unused")
	@Test
	public void PersonalAccount() throws NotEnoughBalance {
		
		PersonalAccount p3;
			
		try{
			p3 = new PersonalAccount(1);
		}catch(Exception e) {
			fail();
		}
		
		assertThrows(NotEnoughBalance.class, () -> {PersonalAccount p4 = new PersonalAccount(-1);});

		return;
	}
	
	@Test
	public void testSetBalance() {

		try{
			p1.setBalance(2500);
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(NotEnoughBalance.class, () -> p1.setBalance(-1000));
		return;
	}
	
	@Test
	public void testGetBalance() {
		assertTrue(p1.getBalance().equals(0));
		return;
	}
}