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

public class BeverageTest extends junit.framework.TestCase {

	Beverage b1, b2, b3, b4, b5, b6;
	
	public BeverageTest() throws BeverageException {
		setUp();
	}
	
	protected void setUp() throws BeverageException {
		
		b1 = new Beverage(0, "Caffe", 3000, 10, 0);
		b2 = new Beverage(1, "The", 5000, 8, 0);
			 
	}
	
	@Test
	public void Beverage() throws BeverageException {
		
		Beverage b3;
			
		try{
			b3 = new Beverage(2, "Caffe", 3000, 10, 0);
		}catch(Exception e) {
			fail();
		}
		
		assertThrows(BeverageException.class, () -> {Beverage b4 = new Beverage(3, "Caff3", 3000, 10, 0);});
		assertThrows(BeverageException.class, () -> {Beverage b5 = new Beverage(4, "Caffe", -3000, 10, 0);});
		assertThrows(BeverageException.class, () -> {Beverage b6 = new Beverage(5, "Caffe", 3000, -10, 0);});

		return;
	}
	
	@Test
	public void testSetName() {

		try{
			b1.setName("Caffe");
		}catch(Exception e) {	
			fail();
		}	
		assertThrows(BeverageException.class, () -> b1.setName("Th3"));
		return;
		}
	
	@Test
	public void testGetName() {
		assertTrue(b1.getName().equals("Caffe"));
		return;
	}
	
	@Test
	public void testSetPrice() {
		
		try{
			b2.setPrice(1000);
		}catch(Exception e) {	
			fail();
		}
		assertThrows(BeverageException.class, () -> b2.setPrice(-1000));
		return;
	}
	
	@Test
	public void testGetPrice() {
		assertTrue(b1.getPrice() == 3000);
		return;
	}
	
	@Test
	public void testSetQuantityPerBox() {
		try {
			b2.setQuantityPerBox(10);
		}catch(Exception e) {
			fail();
		}
		assertThrows(BeverageException.class, () -> b2.setQuantityPerBox(-10));
		return;
	}
	
	@Test
	public void TestGetQuantityPerBox() {
		assertTrue(b1.getQuantityPerBox() == 10);
		return;
	}
	
	@Test
	public void testSetAvailableQuantity() {
		try {
			b2.setAvailableQuantity(10);
		}catch(Exception e) {
			fail();
		}
		assertThrows(BeverageException.class, () -> b2.setAvailableQuantity(-10));
		return;
	}
	
	@Test
	public void testGetAvailableQuantity() {
		assertTrue(b1.getAvailableQuantity() == 0);
		return;
	}
	
}
