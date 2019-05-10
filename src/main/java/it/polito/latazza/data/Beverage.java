package it.polito.latazza.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Beverage implements Serializable{
	
	//default serialVersion id
    private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private String name;
	private Integer price;
	private Integer quantityPerBox;
	private Integer availableQuantity;
	
	private static final String filepath=(new File("beverages.txt")).getAbsolutePath();
	
	public Beverage(Integer ID, String name, Integer price, Integer quantityPerBox, Integer availableQuantity) {
		
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.quantityPerBox = quantityPerBox;
		this.availableQuantity = availableQuantity;
		
		this.WriteObjectToFile(this);
	}
	
	public Integer getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getQuantityPerBox() {
		return quantityPerBox;
	}
	
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setQuantityPerBox(Integer quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	public void WriteObjectToFile(Object serObj) {
		 
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }	
	
}
