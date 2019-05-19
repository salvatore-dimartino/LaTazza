package it.polito.latazza.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polito.latazza.exceptions.NotEnoughBalance;

public class LaTazzaAccount {
	
	private Integer total;

	public LaTazzaAccount(Integer total) throws NotEnoughBalance{
		if(total >= 0)
			this.total = total;
		else
            throw new NotEnoughBalance();

	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) throws NotEnoughBalance {
		if(total >= 0)
			this.total = total;
		else
            throw new NotEnoughBalance();
	}
	
	@SuppressWarnings("unchecked")
	public void toJsonLaTazzaAccount() {
		// read the json file
		JSONParser parser = new JSONParser();
		JSONObject j_file = new JSONObject();
		
		File myfile = new File("LaTazzaAccount.json");
		try {
			myfile.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		try {
			j_file = (JSONObject) parser.parse(new FileReader("./LaTazzaAccount.json"));
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
		}		
		
		j_file.put("Balance", this.getTotal().toString());
						
		// write the json object to the file
		try (FileWriter file = new FileWriter("./LaTazzaAccount.json")) {
			file.write(j_file.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
