package it.polito.latazza.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.DateException;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.beans.Transient;
import java.sql.Date;

import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;

public class DataImplWhite extends junit.framework.TestCase {

    DataImpl data1 = new DataImpl();
	Employee e1, e2, e3;
	Beverage b1, b2, b3;

    @Test
    public void testDataImpl() {
		
		return;
    }

    @Test
    public void testSellCapsules() throws EmployeeException, BeverageException, NotEnoughCapsules{
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.sellCapsules(0,0,10,false));
            data1.createEmployee("Massimo","Priano");
            assertThrows(BeverageException.class, () -> data1.sellCapsules(0,0,10,false));
            data1.createBeverage("Caffe",10,100);
            assertThrows(NotEnoughCapsules.class, () -> data1.sellCapsules(0,0,10,false));
            data1.createEmployee("Massimo","Priano");
            data1.rechargeAccount(0,1000);
            data1.buyBoxes(0,2);
            assertTrue(data1.sellCapsules(0,0,0,false)==1000);
            assertTrue(data1.sellCapsules(0,0,10,false)==1000);
            assertTrue(data1.sellCapsules(0,0,10,true)==900);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void testSellCapsulesToVisitor() throws BeverageException, NotEnoughCapsules{
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.sellCapsulesToVisitor(0,10));
            data1.createBeverage("Caffe",10,100);
            assertThrows(NotEnoughCapsules.class, () -> data1.sellCapsulesToVisitor(0,10));
            data1.createEmployee("Massimo","Priano");
            data1.rechargeAccount(0,1000);
            data1.buyBoxes(0,2);
            data1.sellCapsulesToVisitor(0,0);
            data1.sellCapsulesToVisitor(0,10);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void testRechargeAccount() throws EmployeeException{
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.rechargeAccount(0,1000));
            data1.createEmployee("Massimo","Priano");
            assertTrue(data1.rechargeAccount(0,0)==0);
            assertTrue(data1.rechargeAccount(0,1000)==1000);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testBuyBoxes() throws BeverageException, NotEnoughBalance{
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.buyBoxes(0,2));
            assertThrows(BeverageException.class, () -> data1.buyBoxes(0,-2));
            data1.createBeverage("Caffe",10,100);
            assertThrows(BeverageException.class, () -> data1.buyBoxes(0,-2));
            assertThrows(NotEnoughBalance.class, () -> data1.buyBoxes(0,2));
            data1.createEmployee("Nino", "Geppetto");
            data1.rechargeAccount(0,1000);
            data1.buyBoxes(0,2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetEmployeeReport() throws EmployeeException, DateException{
        data1.reset();
        Date start =  new Date(110, 1, 1);
        Date end = new Date(130, 1, 1);
        try{
            assertThrows(EmployeeException.class, () -> data1.getEmployeeReport(0,start,end));
            data1.createEmployee("Massimo","Priano");
            assertThrows(DateException.class, () -> data1.getEmployeeReport(0,null,end));
            assertThrows(DateException.class, () -> data1.getEmployeeReport(0,start,null));
            assertThrows(DateException.class, () -> data1.getEmployeeReport(0,end,start));
            assertTrue(data1.getEmployeeReport(0,start,end).size()==0);
            data1.rechargeAccount(0,1000);
            assertEquals(data1.getEmployeeReport(0,start,end).size(), 1);
            data1.rechargeAccount(0,1000);
            assertTrue(data1.getEmployeeReport(0,start,start).size()==0);
            assertTrue(data1.getEmployeeReport(0,end,end).size()==0);
            assertTrue(data1.getEmployeeReport(0,start,end).size()==2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetReport() throws DateException{
        data1.reset();
        Date start = new Date(110, 1, 1);
        Date end = new Date(120, 1, 1);
        try{
            data1.createEmployee("Massimo","Priano");
            assertThrows(DateException.class, () -> data1.getReport(null,end));
            assertThrows(DateException.class, () -> data1.getReport(start,null));
            assertThrows(DateException.class, () -> data1.getReport(end,start));
            assertTrue(data1.getReport(start,end).size()==0);
            data1.rechargeAccount(0,1000);
            assertEquals(data1.getReport(start,end).size(), 1);
            data1.rechargeAccount(0,1000);
            assertTrue(data1.getReport(start,start).size()==0);
            assertTrue(data1.getReport(end,end).size()==0);
            assertTrue(data1.getReport(start,end).size()==2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testCreateBeverage() throws BeverageException{
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.createBeverage(null,10,100));
            assertThrows(BeverageException.class, () -> data1.createBeverage(null,-10,100));
            assertThrows(BeverageException.class, () -> data1.createBeverage(null,10,-100));
            assertThrows(BeverageException.class, () -> data1.createBeverage(null,-10,-100));
            assertThrows(BeverageException.class, () -> data1.createBeverage("Caffe",-10,100));
            assertThrows(BeverageException.class, () -> data1.createBeverage("Caffe",10,-100));
            assertThrows(BeverageException.class, () -> data1.createBeverage("Caffe",-10,-100));
            assertThrows(BeverageException.class, () -> data1.createBeverage("Caff3",10,100));
            data1.createBeverage("Caffe",10,100);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testUpdateBeverage() throws BeverageException{
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.updateBeverage(0,"Caffe",10,100));
            data1.createBeverage("Caffe",10,100);
            assertThrows(BeverageException.class, () -> data1.updateBeverage(0,"Caff3",10,100));
            data1.updateBeverage(0,"The",5,50);
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testGetBeverageName() throws BeverageException {
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.getBeverageName(0));
            data1.createBeverage("Caffe",10,100);
            assertTrue(data1.getBeverageName(0).equals("Caffe"));
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetBeverageCapsulesPerBox() throws BeverageException {
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.getBeverageCapsulesPerBox(0));
            data1.createBeverage("Caffe",10,100);
            assertTrue(data1.getBeverageCapsulesPerBox(0)==10);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetBeverageBoxPrice() throws BeverageException {
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.getBeverageBoxPrice(0));
            data1.createBeverage("Caffe",10,100);
            assertTrue(data1.getBeverageBoxPrice(0)==100);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetBeveragesId(){
        data1.reset();
        try{
            assertTrue(data1.getBeveragesId().size() == 0);
            data1.createBeverage("Caffe",10,100);
            assertTrue(data1.getBeveragesId().size() == 1);
            data1.createBeverage("The",5,50);
            assertTrue(data1.getBeveragesId().size() == 2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetBeverages(){
        data1.reset();
        try{
            assertTrue(data1.getBeverages().size() == 0);
            data1.createBeverage("Caffe",10,100);
            assertTrue(data1.getBeverages().size() == 1);
            data1.createBeverage("The",5,50);
            assertTrue(data1.getBeverages().size() == 2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetBeverageCapsules() throws BeverageException {
        data1.reset();
        try{
            assertThrows(BeverageException.class, () -> data1.getBeverageCapsules(0));
            data1.createBeverage("Caffe",10,100);
            assertTrue(data1.getBeverageCapsules(0)==0);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testCreateEmployee() throws EmployeeException{
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.createEmployee(null,"Caldarone"));
            assertThrows(EmployeeException.class, () -> data1.createEmployee("Massimo",null));
            data1.createEmployee("Fausto","Repetto");
            assertThrows(EmployeeException.class, () -> data1.createEmployee("Massim0","Caldarone"));
            assertThrows(EmployeeException.class, () -> data1.createEmployee("Massimo","Caldaron3"));
            assertThrows(EmployeeException.class, () -> data1.createEmployee("Massim0","Caldaron3"));
        } catch (EmployeeException e) {
            fail();
        }
    }

    @Test
    public void testUpdateEmployee() throws EmployeeException{
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.updateEmployee(0,"Massimo","Caldarone"));
            data1.createEmployee("Fausto","Repetto");
            data1.updateEmployee(0,"Massimo","Priano");
            assertThrows(EmployeeException.class, () -> data1.updateEmployee(0,"Massim0","Caldarone"));
            assertThrows(EmployeeException.class, () -> data1.updateEmployee(0,"Massimo","Caldaron3"));
            assertThrows(EmployeeException.class, () -> data1.updateEmployee(0,"Massim0","Caldaron3"));
        } catch (EmployeeException e) {
            fail();
        }
    }

    @Test
    public void testGetEmployeeName() throws EmployeeException {
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.getEmployeeName(0));
            data1.createEmployee("Massimo","Priano");
            assertTrue(data1.getEmployeeName(0).equals("Massimo"));
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetEmployeeSurname() throws EmployeeException {
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.getEmployeeSurname(0));
            data1.createEmployee("Massimo","Priano");
            assertTrue(data1.getEmployeeSurname(0).equals("Priano"));
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetEmployeeBalance() throws EmployeeException {
        data1.reset();
        try{
            assertThrows(EmployeeException.class, () -> data1.getEmployeeBalance(0));
            data1.createEmployee("Massimo","Priano");
            assertTrue(data1.getEmployeeBalance(0)==0);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetEmployeesId(){
        data1.reset();
        try{
            assertTrue(data1.getEmployeesId().size() == 0);
            data1.createEmployee("Fausto","Repetto");
            assertTrue(data1.getEmployeesId().size() == 1);
            data1.createEmployee("Massimo","Caldarone");
            assertTrue(data1.getEmployeesId().size() == 2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetEmployees(){
        data1.reset();
        try{
            assertTrue(data1.getEmployees().size() == 0);
            data1.createEmployee("Fausto","Repetto");
            assertTrue(data1.getEmployees().size() == 1);
            data1.createEmployee("Massimo","Caldarone");
            assertTrue(data1.getEmployees().size() == 2);
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void testGetBalance(){
        data1.reset();
        try{
            data1.createEmployee("Massimo","Priano");
            data1.rechargeAccount(0,1000);
            assertTrue(data1.getBalance()==1000);
        } catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void testLoad() throws EmployeeException, BeverageException, NotEnoughBalance, NotEnoughCapsules{
        data1.reset();
        data1.createEmployee("Massimo","Priano");
        data1.createBeverage("Cola", 10, 1000);
        data1.rechargeAccount(0,10000);
        data1.buyBoxes(0, 1);
        data1.sellCapsulesToVisitor(0, 5);
        DataImpl data2 = new DataImpl();

    }
    
}