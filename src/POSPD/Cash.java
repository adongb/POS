package POSPD;

import java.math.BigDecimal;

/**
 * this class contains all the details of the cash class
 */
public class Cash extends Payment {

	/**
	 * this is an empty constructor of the cash class
	 */
	public Cash() {
		
	}

	/**
	 * this constructor instantiates the cash class and passes it amount and the amountTendered
	 * @param amount this is the actual cash amount
	 * @param amtTendered this is the actual amount tendered
	 */
	public Cash(String amount, String amtTendered) {
		
		BigDecimal inum = new BigDecimal(amount); // converts the string entered by the user to a big decimal
		setAmount(inum);
		BigDecimal inum1 = new BigDecimal(amtTendered); // converts the string entered by the user to a big decimal
		setAmtTendered(inum1);
		
	}

	/**
	 * this method makes sure the cash is counted
	 * @return this method returns a boolean
	 */
	public Boolean countsAsCash() {
		return true;
	}

	/**
	 * this method outputs what is contained in the cash class to the screen
	 * @return this method returns a string
	 */
	public String toString() {
		return super.toString();
	}

}