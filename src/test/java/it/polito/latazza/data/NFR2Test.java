package it.polito.latazza.data;

import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class NFR2Test extends junit.framework.TestCase{
	
	DataImplWhite data;
	long begin;
	long end;
	long totalTime;
	
	@Test
	public void TimeBuyBoxes() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testBuyBoxes();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeCreateBeverage() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testCreateBeverage();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeCreateEmployee() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testCreateEmployee();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBalance() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBalance();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBeverageBoxPrice() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBeverageBoxPrice();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBeverageCapsules() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBeverageCapsules();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBeverageCapsulesPerBox() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBeverageCapsulesPerBox();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBeverageName() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBeverageName();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBeverages() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBeverages();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetBeveragesId() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetBeveragesId();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetEmployeeBalance() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetEmployeeBalance();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetEmployeeName() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetEmployeeName();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetEmployeeReport() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules, DateException {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetEmployeeReport();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetEmployees() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetEmployees();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetEmployeesId() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetEmployeesId();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetEmployeeSurname() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetEmployeeSurname();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeGetReport() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules, DateException {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testGetReport();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeLoad() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testLoad();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeRechargeAccount() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testRechargeAccount();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeSellCapsules() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testSellCapsules();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeSellCapsulesToVisitor() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules, DateException {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testSellCapsulesToVisitor();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeUpdateBeverage() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testUpdateBeverage();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
	
	@Test
	public void TimeUpdateEmployee() throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
		data=new DataImplWhite();
		begin=System.currentTimeMillis();
		for(int i=0; i<100; i++) {
			data.testUpdateEmployee();
		}
		end=System.currentTimeMillis();
		totalTime=(end-begin)/100;
		assertTrue(totalTime<500);
	}
}
