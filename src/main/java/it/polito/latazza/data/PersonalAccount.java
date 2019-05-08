package it.polito.latazza.data;

import java.util.HashMap;
import java.util.Map;

public class PersonalAccount {
	private Integer balance;
	private Map<Integer,Transaction> Transactions=new HahMap<Integer,Transaction>
	
	public PersonalAccount(Integer balance) {
		this.balance=balance;
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	
	public void setBalance(Integer balance) {
		this.balance=balance;
	}
	
	public Map<Integer,Transaction> getTransactions(){
		return this.Transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		Transactions.put(transaction.getID(),transaction);
	}
	
	public void addTransaction(Transaction transaction) {
		Transactions.remove(transaction.getID());
	}
}
