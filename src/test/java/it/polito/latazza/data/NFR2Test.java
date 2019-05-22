package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.List;

import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class NFR2Test extends junit.framework.TestCase{
	
	APITest api;
	long begin;
	long end;
	long totalTime;
	
	@Test
	public void TimeTest() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		api=new APITest();
		//1
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario1();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("1-Ok:"+totalTime);
		//2
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario2();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("2-Ok:"+totalTime);
		//3
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario3();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("3-Ok:"+totalTime);
		//4
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario4();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("4-Ok:"+totalTime);
		//5
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario5();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("5-Ok:"+totalTime);
		//6
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario6();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("6-Ok:"+totalTime);
		//7
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario7();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("7-Ok:"+totalTime);
		//8
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario8();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("8-Ok:"+totalTime);
		//9
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario9();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("9-Ok:"+totalTime);
		//10
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario10();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("10-Ok:"+totalTime);
		//11
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario11();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("11-Ok:"+totalTime);
		//12
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			api.Scenario12();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
		System.out.println("12-Ok:"+totalTime);
		//13
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
