package POSPD;

/**
 * this class contains the details of an authorized payment
 */
public abstract class AuthorizedPayment extends Payment {

	/**
	 * this is the authorization code
	 */
	private String authorizedCode;

	

	public String getAuthorizedCode() {
		return this.authorizedCode;
	}

	public void setAuthorizedCode(String authorizedCode) {
		this.authorizedCode = authorizedCode;
	}

	public AuthorizedPayment()
	{
		
	}

	public AuthorizedPayment(String amount, String amtTendered)
	{
		super(amount,amtTendered);
		//this.authorizationCode=authorizationCode;
		
	}
	
	/**
	 * this method checks and confirms whether a payment is authorized or not
	 */
	public abstract Boolean isAuthorized();

	/**
	 * this method counts an authorized payment as cash
	 * @return this method returns a boolean
	 */
	public Boolean countsAsCash() {
		return false;
	}

}