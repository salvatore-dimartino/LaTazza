package it.polito.latazza.data;

import java.util.HashMap;
import java.util.Map;

import it.polito.latazza.exceptions.NotEnoughBalance;

public class PersonalAccount {
	private Integer balance;
	private Map<Integer,Transaction> Transactions=new HashMap<Integer,Transaction>();
	
	public PersonalAccount(Integer balance) throws NotEnoughBalance {
		this.balance=balance;
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	
	public void setBalance(Integer balance) throws NotEnoughBalance {
		if(balance >= 0)
			this.balance=balance;
		else
		throw new NotEnoughBalance();
	}
	
	public Map<Integer,Transaction> getTransactions(){
		return this.Transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		Transactions.put(transaction.getID(),transaction);
	}
	
	public void deleteTransaction(Transaction transaction) {
		Transactions.remove(transaction.getID());
	}
	
	
}
