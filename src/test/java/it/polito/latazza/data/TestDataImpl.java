package it.polito.latazza.data;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;

import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class TestDataImpl {
	Date begin = new Date();
    Date end = new Date();
	List<Integer> Id;
	Map<Integer,String> Emp;
    List<String> Name;
    List<String> Report;
    int i;
    @Test
    public void EmptyList() {
    	DataImpl DataTest = new DataImpl();
        i=1;
        try {
        	DataTest.reset();
    		Emp=DataTest.getEmployees();
        	assertEquals(0,Emp.size());
        	Emp=DataTest.getBeverages();
        	assertEquals(0,Emp.size());
        	DataTest.createEmployee("Fede", "Salvo");
        	Report=DataTest.getEmployeeReport(0,begin,end);
        	assertEquals(0,Report.size());
        	Report=DataTest.getReport(begin,end);
        	assertEquals(0,Report.size());
        } catch(Exception e) {
        	System.out.println("Exception occurs");
			fail();
        }
    }
    
    @Test
    public void ExceptionNotEnoughBalance() {
    	DataImpl DataTest = new DataImpl();
        i=1;
        DataTest.reset();
    	try {
    		DataTest.createBeverage("Caffe",5,500);
    	} catch (Exception e) {
    		System.out.println("Exception occurs");
			fail();
    	}
    	assertThrows(NotEnoughBalance.class, ()->{
            DataTest.buyBoxes(0,5);
        });
    }
    
    public void ExceptionNotEnoughCapsules() {
    	DataImpl DataTest = new DataImpl();
        i=1;
        DataTest.reset();
    	try {
    		DataTest.createEmployee("Antonio","LaRuspa");
    		DataTest.createBeverage("Caffe",5,500);
    		DataTest.rechargeAccount(0,10000);
    	} catch (Exception e) {
    		System.out.println("Exception occurs");
			fail();
    	}
        assertThrows(NotEnoughCapsules.class, ()->{
            DataTest.sellCapsulesToVisitor(0,100000000);
        });
        assertThrows(NotEnoughCapsules.class, ()->{
            DataTest.sellCapsules(0,0,1000,true);
        });
        assertThrows(NotEnoughCapsules.class, ()->{
            DataTest.sellCapsules(0,0,1000,false);
        });
    }
    
    @Test
    public void ExceptionData() {
    	DataImpl DataTest = new DataImpl();
        i=1;
        DataTest.reset();
        try {
        	DataTest.createEmployee("Fede", "Salvo");
        } catch (Exception e) {
        	System.out.println("Exception occurs");
        	fail();
        }
    	assertThrows(DateException.class, ()->{
            DataTest.getEmployeeReport(0,null,end);
        });
        assertThrows(DateException.class, ()->{
            DataTest.getEmployeeReport(0,begin,null);
        });
    }
    
	@Test
	public void ExceptionEmployee() {
		DataImpl DataTest = new DataImpl();
	    i=1;
	    DataTest.reset();
	    try {
	    	DataTest.createBeverage("Caffe",5,500);
	    } catch (Exception e) {
	    	System.out.println("Exception occurs");
			fail();
	    }
		assertThrows(EmployeeException.class, ()->{
            DataTest.updateEmployee(0,"Marco","Antonio");
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.getEmployeeName(0);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.getEmployeeSurname(0);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.getEmployeeBalance(0);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.rechargeAccount(0,10000);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.createEmployee(null,"Fede");
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.createEmployee("Fede",null);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.sellCapsules(2,0,1,true);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.sellCapsules(2,0,1,false);
        });
	}
	
	@Test
	public void ExceptionBeverage() {
		DataImpl DataTest = new DataImpl();
	    i=1;
	    DataTest.reset();
		try {
			DataTest.createEmployee("Antonio","LaRuspa");
		} catch (Exception e) {
			System.out.println("Exception occurs");
			fail();
		}
		assertThrows(BeverageException.class, ()->{
            DataTest.updateBeverage(0,"Latte",8, 3000);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageName(0);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageCapsulesPerBox(0);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageBoxPrice(0);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageCapsules(0);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.createBeverage(null,8,3000);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.sellCapsulesToVisitor(2,1);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.sellCapsules(0,2,1,true);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.sellCapsules(0,2,1,false);
        });
	}
	
	@Test
	public void NewEmployee() {
		DataImpl DataTest = new DataImpl();
	    i=0;
	    DataTest.reset();
		try {
			Id=DataTest.getEmployeesId();
	        Emp=DataTest.getEmployees();
	        assertEquals(0,Id.size());
	        assertEquals(0,Emp.size());
	        assertEquals(0,DataTest.createEmployee("Antonio","LaRuspa").intValue());
	        Id=DataTest.getEmployeesId();
	        Emp=DataTest.getEmployees();
	        assertEquals(1,Id.size());
	        assertEquals(1,Emp.size());
	        Name=Collections.singletonList("Antonio LaRuspa");
	        Id.forEach(elem->{
	        	Emp=DataTest.getEmployees();
	            assertEquals(i,elem.intValue());
	            assertEquals(Emp.get(i),Name.get(i));
	            i++;
	        });
	        i=0;
	        assertEquals(1,DataTest.createEmployee("Eugenio","Vitale").intValue());
	        assertEquals("Antonio",DataTest.getEmployeeName(0));
	        assertEquals("LaRuspa",DataTest.getEmployeeSurname(0));
	        assertEquals("Eugenio",DataTest.getEmployeeName(1));
	        assertEquals("Vitale",DataTest.getEmployeeSurname(1));
	        Id=DataTest.getEmployeesId();
	        Emp=DataTest.getEmployees();
	        assertEquals(2,Id.size());
	        assertEquals(2,Emp.size());
	        Name=Arrays.asList("Antonio LaRuspa", "Eugenio Vitale");
	        Id.forEach(elem->{
	            assertEquals(i,elem.intValue());
	            assertEquals(Emp.get(i),Name.get(i));
	            i++;
	        });
	        i=0;
	        DataTest.updateEmployee(0,"Vincenzo","LaRuspa");
	        DataTest.updateEmployee(1,"Eugenio","Coriandolo");
	        assertEquals("Vincenzo",DataTest.getEmployeeName(0));
	        assertEquals("LaRuspa",DataTest.getEmployeeSurname(0));
	        assertEquals("Eugenio",DataTest.getEmployeeName(1));
	        assertEquals("Coriandolo",DataTest.getEmployeeSurname(1));
	        Id=DataTest.getEmployeesId();
	        Emp=DataTest.getEmployees();
	        assertEquals(2,Id.size());
	        assertEquals(2,Emp.size());
	        Name=Arrays.asList("Vincenzo LaRuspa", "Eugenio Coriandolo");
	        Id.forEach(elem->{
	            assertEquals(i,elem.intValue());
	            assertEquals(Emp.get(i),Name.get(i));
	            i++;
	        });
		} catch (Exception e) {
			System.out.println("Exception occurs");
			fail();
		}
	}
	
	@Test
	public void NewBeverage() {
		DataImpl DataTest = new DataImpl();
	    i=0;
	    DataTest.reset();
		try {
			assertEquals(0,DataTest.createBeverage("Caffe",5,500).intValue());
	        Id=DataTest.getBeveragesId();
	        Emp=DataTest.getBeverages();
	        assertEquals(1,Id.size());
	        assertEquals(1,Emp.size());
	        Name=Collections.singletonList("Caffe");
	        Id.forEach(elem->{
	            assertEquals(i,elem.intValue());
	            assertEquals(Emp.get(i),Name.get(i));
	            i++;
	        });
	        i=0;
	        assertEquals(1,DataTest.createBeverage("The",3,150).intValue());
	        assertEquals("Caffe",DataTest.getBeverageName(0));
	        assertEquals(5,DataTest.getBeverageCapsulesPerBox(0).intValue());
	        assertEquals(500,DataTest.getBeverageBoxPrice(0).intValue());
	        assertEquals("The",DataTest.getBeverageName(1));
	        assertEquals(3,DataTest.getBeverageCapsulesPerBox(1).intValue());
	        assertEquals(150,DataTest.getBeverageBoxPrice(1).intValue());
	        Id=DataTest.getBeveragesId();
	        Emp=DataTest.getBeverages();
	        assertEquals(2,Id.size());
	        assertEquals(2,Emp.size());
	        Name=Arrays.asList("Caffe", "The");
	        Id.forEach(elem->{
	            assertEquals(i,elem.intValue());
	            assertEquals(Emp.get(i),Name.get(i));
	            i++;
	        });
	        i=0;
	        DataTest.updateBeverage(0,"Cioccolata",5,500);
	        DataTest.updateBeverage(1,"The",10,1500);
	        assertEquals("Cioccolata",DataTest.getBeverageName(0));
	        assertEquals(5,DataTest.getBeverageCapsulesPerBox(0).intValue());
	        assertEquals(500,DataTest.getBeverageBoxPrice(0).intValue());
	        assertEquals("The",DataTest.getBeverageName(1));
	        assertEquals(10,DataTest.getBeverageCapsulesPerBox(1).intValue());
	        assertEquals(1500,DataTest.getBeverageBoxPrice(1).intValue());
	        Id=DataTest.getBeveragesId();
	        Emp=DataTest.getBeverages();
	        assertEquals(2,Id.size());
	        assertEquals(2,Emp.size());
	        Name=Arrays.asList("Cioccolata", "The");
	        Id.forEach(elem->{
	            assertEquals(i,elem.intValue());
	            assertEquals(Emp.get(i),Name.get(i));
	            i++;
	        });
		} catch (Exception e) {
			System.out.println("Exception occurs");
			fail();
		}
	}
	
	@Test
	public void Recharge() {
		DataImpl DataTest = new DataImpl();
	    i=0;
	    DataTest.reset();
		try {
	        DataTest.createEmployee("Antonio","LaRuspa");
	        DataTest.createEmployee("Eugenio","Vitale");
	        assertEquals(5000,DataTest.rechargeAccount(0,5000).intValue());
	        assertEquals(5000,DataTest.getEmployeeBalance(0).intValue());
	        assertEquals(5000,DataTest.getBalance().intValue());
	        assertEquals(15000,DataTest.rechargeAccount(0,10000).intValue());
	        assertEquals(15000,DataTest.getEmployeeBalance(0).intValue());
	        assertEquals(15000,DataTest.getBalance().intValue());
	        assertEquals(7500,DataTest.rechargeAccount(0,-7500).intValue());
	        assertEquals(7500,DataTest.getEmployeeBalance(0).intValue());
	        assertEquals(7500,DataTest.getBalance().intValue());
	        assertEquals(50000,DataTest.rechargeAccount(1,50000).intValue());
	        assertEquals(50000,DataTest.getEmployeeBalance(1).intValue());
	        assertEquals(57500,DataTest.getBalance().intValue());
		} catch (Exception e) {
			System.out.println("Exception occurs");
			fail();
		}
	}
	
	@Test
	public void BuyTest(){
		DataImpl DataTest = new DataImpl();
	    i=0;
	    DataTest.reset();
		try {
			DataTest.createEmployee("Antonio","LaRuspa");
			DataTest.createBeverage("Caffe",5,500);
			DataTest.rechargeAccount(0,7500);
			assertEquals(7500,DataTest.getBalance().intValue());
			DataTest.buyBoxes(0,5);
			assertEquals(5000,DataTest.getBalance().intValue());
			assertEquals(25,DataTest.getBeverageCapsules(0).intValue());
			DataTest.sellCapsulesToVisitor(0,10);
			assertEquals(15,DataTest.getBeverageCapsules(0).intValue());
			assertEquals(7500,DataTest.sellCapsules(0,0,5,false).intValue());
			assertEquals(10,DataTest.getBeverageCapsules(0).intValue());
			assertEquals(7000,DataTest.sellCapsules(0,0,5,true).intValue());
	        assertEquals(5,DataTest.getBeverageCapsules(0).intValue());
		} catch (Exception e) {
			System.out.println("Exception occurs");
			fail();
		}
	}
	
	public void ReportTest() {
		DataImpl DataTest = new DataImpl();
	    i=0;
	    DataTest.reset();
        try{
        	DataTest.createEmployee("Antonio","LaRuspa");
        	DataTest.createBeverage("Caffe",5,500);
        	DataTest.rechargeAccount(0,1000000);
        	DataTest.buyBoxes(0,25);
        	DataTest.sellCapsules(0,0,5,false);
        	DataTest.sellCapsules(0,0,5,true);
        	end=new Date();
        	Report=DataTest.getEmployeeReport(0,begin,end);
        	assertEquals(3,Report.size());
        	Name=Arrays.asList("RECHARGE", "CASH", "BALANCE");
        	Report.forEach(elem->{
        		String[] parts=elem.split(" ");
        		assertEquals(parts[2],Name.get(i));
        		i++;
        	});
        	i=0;
        	Report=DataTest.getReport(begin,end);
        	assertEquals(4,Report.size());
        	Name=Arrays.asList("RECHARGE", "BUY", "CASH", "BALANCE");
        	Report.forEach(elem->{
        		String[] parts=elem.split(" ");
        		assertEquals(parts[2],Name.get(i));
        		i++;
        	});
        } catch(Exception e) {
        	System.out.println("Exception occurs");
			fail();
        }
	}
}