package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class BoxPurchaseTest extends junit.framework.TestCase {
	
	BoxPurchase p1, p2;
	Date d1;
	Beverage b1;
		
		public BoxPurchaseTest() throws Exception {
			setUp();
		}
		
		protected void setUp() throws Exception {
			
			d1 = new Date();
			b1 = new Beverage(0, "Caffe", 3000, 10, 0);
			p1 = new BoxPurchase(0, d1, 100, b1);
			
		}
		
		@Test
		public void testConsumption() throws Exception {
			
			BoxPurchase p3;
			
			try{
				p3 = new BoxPurchase(0, d1, 200, b1);
			}catch(Exception e) {
				fail();
			}
			
			assertThrows(Exception.class, () -> {BoxPurchase p4 = new BoxPurchase(0, d1, -200, b1);});
			
			return;
		}
		
		@Test
		public void testSetQuantity() {
			try {
				p1.setQuantity(10);
			}catch(Exception e) {
				fail();
			}
			
			assertThrows(Exception.class, () -> {p1.setQuantity(-10);});
			
			return;
		}
		
		@Test
		public void testGetQuantity() {
			assertTrue(p1.getQuantity() == 100);
			return;
		}

}
