package POSPD;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

/**
 * this class contains all the details of a payment through a card
 */
public class Credit extends AuthorizedPayment {

	/**
	 * this is the type of card, debit or credit
	 */
	private String cardType;
	/**
	 * this is the account number associated with the card used for the payment
	 */
	private String acctNumber;
	/**
	 * this method checks for the expiration date of a specific card
	 */
	private LocalDate expireDate;

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAcctNumber() {
		return this.acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public LocalDate getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * this is an empty constructor of the credit class
	 */
	public Credit() {
		super();
		
	}

	/**
	 * this constructor instantiates the credit class and passes it cardType, acctNumber and the expirationDate
	 * @param cardType
	 * @param acctNumber
	 * @param expireDate
	 */
	public Credit(String cardType, String acctNumber, String expireDate,
			String amount, String amtTendered) {
		
		super(amount, amtTendered);
		setCardType(cardType);
		setAcctNumber(acctNumber);
		LocalDate dateLocal = LocalDate.parse(expireDate, DateTimeFormatter.ofPattern("MM/d/yyyy")); // to change the string from the user's input to LocalDate.
		setExpireDate(dateLocal);
		
	}

	/**
	 * this method checks and determines whether the payment is authorized or not
	 * @return this method returns a boolean
	 */
	public Boolean isAuthorized() {
		return true;
	}

	/**
	 * this method will output what is contained in the credit to the screen
	 */
	public String toString() {
		return super.toString();
	}

}