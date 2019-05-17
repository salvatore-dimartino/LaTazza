package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import it.polito.latazza.data.*;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class LaTazzaAccountTest extends junit.framework.TestCase {

	LaTazzaAccount l1, l2, l3, l4;
	
	public LaTazzaAccountTest() throws NotEnoughBalance {
		setUp();
	}
	
	protected void setUp() throws NotEnoughBalance {
		
		l1 = new LaTazzaAccount(0);
		l2 = new LaTazzaAccount(1000);
			 
	}
	
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
