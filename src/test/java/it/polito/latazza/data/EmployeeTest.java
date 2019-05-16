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

public class EmployeeTest extends junit.framework.TestCase {

	Employee e1, e2, e3, e4, e5, e6;
	
	public BeverageTest() throws BeverageException {
		setUp();
	}
	
	protected void setUp() throws BeverageException {
		
		e1 = new Employee("Nicola", "Molino", 0);
		e2 = new Employee("Paolo", "Vinovo", 1);
			 
	}
	
	@Test
	public void Beverage() throws BeverageException {
		
		Employee e3;
			
		try{
			e3 = new Employee("Paolo", "Vinovi", 1);
		}catch(Exception e) {
			fail();
		}
		
		assertThrows(EmployeeException.class, () -> {Employee e4 = new Employee("Nicola", "Molino", -1);});
		assertThrows(EmployeeException.class, () -> {Employee e5 = new Employee("Nicola", "Molin329o", 0);});
		assertThrows(EmployeeException.class, () -> {Employee e6 = new Employee("Nico3277la", "Molino", 0);});

		return;
	}
	
	@Test
	public void testSetName() {

		try{
			b1.setName("Vincenzo");
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(EmployeeException.class, () -> b1.setName("Vinc879nzo"));
		return;
		}
	
	@Test
	public void testGetName() {
		assertTrue(b1.getName().equals("Vincenzo"));
		return;
	}
	
	@Test
	public void testSetSurname() {

		try{
			e1.setName("Valencia");
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(EmployeeException.class, () -> e1.setName("Val219ncia"));
		return;
		}
	
	@Test
	public void testGetSurname() {
		assertTrue(e1.getName().equals("Valencia"));
		return;
	}
	
}