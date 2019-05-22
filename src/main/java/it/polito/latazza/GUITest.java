/*
* You have to execute this alternative main for each time you want to run a different script test.
*/

package it.polito.latazza;

import it.polito.latazza.data.DataImpl;
import it.polito.latazza.data.DataInterface;
import it.polito.latazza.exceptions.BeverageException;
import it.polito.latazza.exceptions.EmployeeException;
import it.polito.latazza.exceptions.NotEnoughBalance;
import it.polito.latazza.exceptions.NotEnoughCapsules;
import it.polito.latazza.gui.MainSwing;

public class GUITest {
	
	public static void main(String[] args) throws BeverageException, EmployeeException, NotEnoughBalance, NotEnoughCapsules {
				
		DataInterface data = new DataImpl();
		data.reset();
		data.createBeverage("Coffee", 12, 450);
		data.createBeverage("Thè", 8, 550);
		data.createEmployee("Mario", "Rossi");
		data.createEmployee("Giacomo", "Leopardi");
		data.rechargeAccount(0, 10000);
		data.buyBoxes(0, 2);
		new MainSwing(data);
		
	}

}
