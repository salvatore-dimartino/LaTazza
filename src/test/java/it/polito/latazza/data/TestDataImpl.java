Fimport static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;
import it.polito.latazza.data;
import jdk.internal.instrumentation.TypeMapping;

import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class TestDataImpl {

	@Test
	public void testExample() {
		private DataImpl DataTest=new DataImpl();
		List<Integer> Id;
        Map<Integer,String> Emp;
        List<String> Name;
        List<String> Report;
        int i=1;
        DataTest.reset();
        assertThrows(EmployeeException.class, ()->{
            DataTest.updateEmployee(1,"Marco","Antonio");
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.getEmployeeName(1);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.getEmployeeSurname(1);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.getEmployeeBalance(1);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.rechargeAccount(1,10000);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.createEmployee(null,"Fede");
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.createEmployee("Fede",null);
        });
        assertEquals(1,DataTest.createEmployee("Antonio","LaRuspa"));
        Id=DataTest.getEmployeesId();
        Emp=DataTest.getEmployees();
        assertEquals(1,Id.size());
        assertEquals(1,Emp.size());
        Name=Collections.singletonList("Antonio LaRuspa");
        Id.forEach(elem->{
            assertEquals(i,elem);
            assertEquals(Emp.get(i),Name.get(i));
            i++;
        });
        i=1;
        assertEquals(2,DataTest.createEmployee("Eugenio","Vitale"));
        assertEquals("Antonio",DataTest.getEmployeeName(1));
        assertEquals("LaRuspa",DataTest.getEmployeeSurname(1));
        assertEquals("Eugenio",DataTest.getEmployeeName(2));
        assertEquals("Vitale",DataTest.getEmployeeSurname(2));
        Id=DataTest.getEmployeesId();
        Emp=DataTest.getEmployees();
        assertEquals(2,Id.size());
        assertEquals(2,Emp.size());
        Name=Arrays.asList("Antonio LaRuspa", "Eugenio Vitale");
        Id.forEach(elem->{
            assertEquals(i,elem);
            assertEquals(Emp.get(i),Name.get(i));
            i++;
        });
        i=1;
        DataTest.updateEmployee(1,"Vincenzo","LaRuspa");
        DataTest.updateEmployee(2,"Eugenio","Coriandolo");
        assertEquals("Vincenzo",DataTest.getEmployeeName(1));
        assertEquals("LaRuspa",DataTest.getEmployeeSurname(1));
        assertEquals("Eugenio",DataTest.getEmployeeName(2));
        assertEquals("Coriandolo",DataTest.getEmployeeSurname(2));
        Id=DataTest.getEmployeesId();
        Emp=DataTest.getEmployees();
        assertEquals(2,Id.size());
        assertEquals(2,Emp.size());
        Name=Arrays.asList("Vincenzo LaRuspa", "Eugenio Coriandolo");
        Id.forEach(elem->{
            assertEquals(i,elem);
            assertEquals(Emp.get(i),Name.get(i));
            i++;
        });
        i=1;
        assertEquals(5000,DataTest.rechargeAccount(1,5000));
        assertEquals(5000,DataTest.getEmployeeBalance(1));
        assertEquals(5000,DataTest.getBalance());
        assertEquals(15000,DataTest.rechargeAccount(1,10000));
        assertEquals(15000,DataTest.getEmployeeBalance(1));
        assertEquals(15000,DataTest.getBalance());
        assertEquals(7500,DataTest.rechargeAccount(1,-7500));
        assertEquals(7500,DataTest.getEmployeeBalance(1));
        assertEquals(7500,DataTest.getBalance());
        assertEquals(50000,DataTest.rechargeAccount(2,5000));
        assertEquals(50000,DataTest.getEmployeeBalance(2));
        assertEquals(57500,DataTest.getBalance());
        assertThrows(BeverageException.class, ()->{
            DataTest.updateBeverage(1,"Latte",8, 3000);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageName(1);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageCapsulesPerBox(1);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageBoxPrice(1);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.getBeverageCapsules(1);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.createBeverage(null,8,3000);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.createBeverage("Latte",null,3000);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.createBeverage("Latte",8,null);
        });
        assertEquals(1,DataTest.createBeverage("Caffe¨",5,500));
        Id=DataTest.getBeveragesId();
        Emp=DataTest.getBeverages();
        assertEquals(1,Id.size());
        assertEquals(1,Emp.size());
        Name=Collections.singletonList("Caffe¨");
        Id.forEach(elem->{
            assertEquals(i,elem);
            assertEquals(Emp.get(i),Name.get(i));
            i++;
        });
        i=1;
        assertEquals(2,DataTest.createBeverage("The",3,150));
        assertEquals("Caffe¨",DataTest.getBeverageName(1));
        assertEquals(5,DataTest.getBeverageCapsulesPerBox(1));
        assertEquals(500,DataTest.getBeverageBoxPrice(1));
        assertEquals("The",DataTest.getBeverageName(2));
        assertEquals(3,DataTest.getBeverageCapsulesPerBox(2));
        assertEquals(150,DataTest.getBeverageBoxPrice(2));
        Id=DataTest.getBeveragesId();
        Emp=DataTest.getBeverages();
        assertEquals(2,Id.size());
        assertEquals(2,Emp.size());
        Name=Arrays.asList("Caffe¨", "The");
        Id.forEach(elem->{
            assertEquals(i,elem);
            assertEquals(Emp.get(i),Name.get(i));
            i++;
        });
        i=1;
        DataTest.updateBeverage(1,"Cioccolata",5,500);
        DataTest.updateBeverage(2,"The",10,1500);
        assertEquals("Cioccolata",DataTest.getBeverageName(1));
        assertEquals(5,DataTest.getBeverageCapsulesPerBox(1));
        assertEquals(500,DataTest.getBeverageBoxPrice(1));
        assertEquals("The",DataTest.getBeverageName(2));
        assertEquals(10,DataTest.getBeverageCapsulesPerBox(2));
        assertEquals(1500,DataTest.getBeverageBoxPrice(2));
        Id=DataTest.getBeveragesId();
        Emp=DataTest.getBeverages();
        assertEquals(2,Id.size());
        assertEquals(2,Emp.size());
        Name=Arrays.asList("CaffÃƒÂ¨", "Cioccolata");
        Id.forEach(elem->{
            assertEquals(i,elem);
            assertEquals(Emp.get(i),Name.get(i));
            i++;
        });
        i=1;
        DataTest.buyBoxes(1,5);
        assertEquals(25,DataTest.getBeverageCapsules(1));
        DataTest.sellCapsulesToVisitor(1,10);
        assertEquals(15,DataTest.getBeverageCapsules(1));
        assertEquals(7500,DataTest.sellCapsules(1,1,5,false));
        assertEquals(10,DataTest.getBeverageCapsules(1));
        assertEquals(5000,DataTest.sellCapsules(1,1,5,true));
        assertEquals(500,DataTest.getBalance());
        assertEquals(45000,DataTest.getBeverageCapsules(1));
        assertThrows(BeverageException.class, ()->{
            DataTest.buyBoxes(3,1);
        });
        assertThrows(NotEnoughBalance.class, ()->{
            DataTest.buyBoxes(1,100000000);
        });
        assertEquals(55000,DataTest.getBalance());
        assertThrows(BeverageException.class, ()->{
            DataTest.sellCapsulesToVisitor(3,1);
        });
        assertThrows(NotEnoughBalance.class, ()->{
            DataTest.sellCapsulesToVisitor(1,100000000);
        });
        assertEquals(55000,DataTest.getBalance());
        assertThrows(EmployeeException.class, ()->{
            DataTest.sellCapsules(3,1,1,true);
        });
        assertThrows(EmployeeException.class, ()->{
            DataTest.sellCapsules(3,1,1,false);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.sellCapsules(1,3,1,true);
        });
        assertThrows(BeverageException.class, ()->{
            DataTest.sellCapsules(1,3,1,false);
        });
        assertThrows(NotEnoughCapsules.class, ()->{
            DataTest.sellCapsules(1,1,1000,true);
        });
        assertThrows(NotEnoughCapsules.class, ()->{
            DataTest.sellCapsules(1,1,1000,false);
        });
        assertEquals(5000,DataTest.getEmployeeBalance(1));
        Date begin = new Date(0);
        Date end = new Date(2000000000000);
        Report=DataTest.getEmployeeReport(1,begin,end);
        assertEquals(5,Report.size());
        Name=Arrays.asList("RECHARGE", "RECHARGE", "RECHARGE", "CASH", "BALANCE");
        Report.forEach(elem->{
            String[] parts=elem.split(" ");
            assertEquals(parts[2],Name.get(i));
            i++;
        });
        i=1;
        assertThrows(DateException.class, ()->{
            DataTest.getEmployeeReport(1,end,begin);
        });
        Report=DataTest.getReport(begin,end);
        assertEquals(7,Report.size());
        Name=Arrays.asList("RECHARGE", "RECHARGE", "RECHARGE", "RECHARGE", "BUY", "CASH", "BALANCE");
        Report.forEach(elem->{
            String[] parts=elem.split(" ");
            assertEquals(parts[2],Name.get(i));
            i++;
        });
        assertThrows(DateException.class, ()->{
            DataTest.getReport(end,begin);
        });
	}

}