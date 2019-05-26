package it.polito.latazza.data;

import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class NFR2Test extends junit.framework.TestCase{
	
	APITest api;
	long begin;
	long end;
	long totalTime;
	
	@Test
	public void Scenario1() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario1();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("1-Ok:"+totalTime);
	}
		
	@Test
	public void Scenario2() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario2();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("2-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario3() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario3();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("3-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario4() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario4();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("4-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario5() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario5();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("5-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario6() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario6();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("6-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario7() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario7();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("7-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario8() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario8();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("8-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario9() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario9();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("9-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario10() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario10();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("10-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario11() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario11();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("11-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario12() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario12();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("12-Ok:"+totalTime);
	}
	
	@Test
	public void Scenario13() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario13();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("13-Ok:"+totalTime);
	}
}
