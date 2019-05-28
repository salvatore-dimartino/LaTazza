package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ConsumptionTest extends junit.framework.TestCase {
	
	Consumption c1, c2;
	Date d1;
	Beverage b1;
	Employee e1;
		
		public ConsumptionTest() throws Exception {
			setUp();
		}
		
		protected void setUp() throws Exception {
			
			d1 = new Date();
			b1 = new Beverage(0, "Caffe", 3000, 10, 0);
			e1 = new Employee("Ludito", "Arduca", 0);
			c1 = new Consumption(0, d1, 100, b1, e1, "CASH");
			
		}
		
		@SuppressWarnings("unused")
		@Test
		public void testConsumption() throws Exception {
			
			Consumption c3;
			
			try{
				c3 = new Consumption(0, d1, 200, b1, e1, "BALANCE");
			}catch(Exception e) {
				fail();
			}
			
			assertThrows(Exception.class, () -> {Consumption c4 = new Consumption(0, d1, -200, b1, e1, "BALANCE");});
			
			return;
		}
		
		@Test
		public void testSetQuantity() {
			try {
				c1.setQuantity(10);
			}catch(Exception e) {
				fail();
			}
			
			assertThrows(Exception.class, () -> {c1.setQuantity(-10);});
			
			return;
		}
		
		@Test
		public void testGetQuantity() {
			assertTrue(c1.getQuantity() == 100);
			return;
		}
}
