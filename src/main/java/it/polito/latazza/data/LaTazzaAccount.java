package it.polito.latazza.data;

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
}
