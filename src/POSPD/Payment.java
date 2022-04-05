package POSPD;

import java.math.BigDecimal;

/**
 * this class contains all the details of the payment class
 */
public class Payment {

	/**
	 * this is the amount passed in for the payment
	 */
	private BigDecimal amount;
	/**
	 * this is the amount tendered for a particular payment
	 */
	private BigDecimal amtTendered;
	
	public Payment()
	{
		
	}
	public Payment(String amount, String amtTendered)
	{
		this.amount=new BigDecimal(amount);
		this.amtTendered=new BigDecimal(amtTendered);
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmtTendered() {
		return this.amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered) {
		this.amtTendered = amtTendered;
	}

	/**
	 * this method makes sure a particular payment is counted as cash
	 * @return this method returns a boolean
	 */
	public Boolean countsAsCash() {
		return false;
	}

}