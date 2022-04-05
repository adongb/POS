package POSPD;

import java.math.BigDecimal;

/**
 * this class will contain the amount of money in the drawer and the different drawer positions.
 */
public class CashDrawer {

	/**
	 * this is the actual the cash amount
	 */
	private BigDecimal cashAmount;
	/**
	 * this is the actual position of the cash drawer
	 */
	private int position;

	public BigDecimal getCashAmount() {
		return this.cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * this is an empty constructor to instantiate the CashDrawer class
	 * @param i 
	 * @param bigDecimal 
	 */
	public CashDrawer(BigDecimal cash, int position)
	{
		this.cashAmount=cash;
		this.position =position;
	}

	/**
	 * this method will remove the cash from the cash drawer
	 * @param cash this is the actual cash to be removed
	 */
	public void removeCash(BigDecimal cash) {
		this.cashAmount = this.cashAmount.subtract(cash);
	}

	/**
	 * this method will add a given amount of cash to the cash drawer
	 * @param cash this is the actual added cash
	 */
	public void addCash(BigDecimal cash) {
		this.cashAmount = this.cashAmount.add(cash);
	}

	/**
	 * this will output what is stored in the CashDrawer class
	 * @return a string will be returned by this class
	 */
	public String toString() {
		return this.cashAmount+"";
	}

}