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

	Employee e1, e2, e3, e4, e5;
	
	public EmployeeTest() throws EmployeeException {
		setUp();
	}
	
	protected void setUp() throws EmployeeException {
		
		e1 = new Employee("Nicola", "Molino", 0);
		e2 = new Employee("Paolo", "Vinovo", 1);
			 
	}
	
	@Test
	public void testEmployee() throws EmployeeException {
		
		Employee e3;
			
		try{
			e3 = new Employee("Paolo", "Vinovi", 1);
		}catch(Exception e) {
			fail();
		}
		
		assertThrows(EmployeeException.class, () -> {Employee e4 = new Employee("Nicola", "Molin329o", 0);});
		assertThrows(EmployeeException.class, () -> {Employee e5 = new Employee("Nico3277la", "Molino", 0);});

		return;
	}
	
	@Test
	public void testSetName() {

		try{
			e1.setName("Vincenzo");
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(EmployeeException.class, () -> e1.setName("Vinc879nzo"));
		return;
		}
	
	@Test
	public void testGetName() {
		assertTrue(e1.getName().equals("Nicola"));
		return;
	}
	
	@Test
	public void testSetSurname() {

		try{
			e1.setSurname("Valencia");
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(EmployeeException.class, () -> e1.setSurname("Val219ncia"));
		return;
		}
	
	@Test
	public void testGetSurname() {
		assertTrue(e1.getSurname().equals("Molino"));
		return;
	}
	
}
