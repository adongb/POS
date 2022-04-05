package POSPD;

import java.math.BigDecimal;

/**
 * this class contains all the details of the Check class
 */
public class Check extends AuthorizedPayment {

	/**
	 * this is the routing number on a particular check
	 */
	private String routingNumber;
	/**
	 * this is the account number on a particular check
	 */
	private String accountNumber;
	/**
	 * this is the check number of a particular check
	 */
	private String checkNumber;

	public String getRoutingNumber() {
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * this is an empty constructor of the check class
	 */
	public Check() {
		
	
	}

	/**
	 * this constructor instantiates the check class and passes it amount and a certain accountNumber
	 * @param amount this is the actual amount on the check
	 * @param accountNumber this is the actual accountNumber on the check
	 */
	public Check(String amount, String accountNumber,String amtTendered, String rountingNumber, String checkNumber) {
		super(amount,amtTendered);
		
		BigDecimal inum = new BigDecimal(amount); // converts the string entered by the user to a big decimal
		setAmount(inum);
		setAccountNumber(accountNumber);
		setRoutingNumber(rountingNumber);
		setCheckNumber(checkNumber);
		
		
		
	}

	/**
	 * this method checks and determines whether the check is authorized or not
	 * @return this method returns a boolean
	 */
	public Boolean isAuthorized() {
		return true;
	}

}