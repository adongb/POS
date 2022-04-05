package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * this class contains the details of promotional prices
 */
public class PromoPrice extends Price {

	/**
	 * this is the endDate of the promotional price
	 */
	private LocalDate endDate;

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * this is an empty constructor
	 */
	public PromoPrice() {
		
	}

	/**
	 * this constructor instantiates the promoPrice class and passes it the price, effectiveDate and endDate.
	 * @param price this is the actual price of the promotion.
	 * @param effectiveDate this is the actual effectiveDate of the promotion
	 * @param endDate this is the actual endDate of the promotion
	 */
	public PromoPrice(String price, String effectiveDate, String endDate) {
		setEffectiveDate(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy")));
		setEndDate(LocalDate.parse(endDate, DateTimeFormatter.ofPattern("M/d/yy")));
		setPrice(new BigDecimal (price));
	}

	/**
	 * this method will set the effective date
	 * @param date this is the actual effective date
	 * @return this method will return a boolean
	 */
	public Boolean isEffective(LocalDate date) {
		
		return  (this.getEffectiveDate().isBefore(date) || this.getEffectiveDate().isEqual(date)) && (this.getEndDate().isAfter(date) || this.getEndDate().isEqual(date));
		
	}

	public boolean isPromo()
	{
		return true;
	}


	/**
	 * this method will output what is contained in promoprice to the screen
	 * @return this method will return a string
	 */
	public String toString() {
		return getPrice().toString() + " " + getEffectiveDate().toString() + " " + getEndDate().toString();
	}

	public void setEndDate(String date) {
	this.endDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	}

}