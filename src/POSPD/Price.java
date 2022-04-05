package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * this class will contain all the details of the price Class
 */
public class Price implements Comparable<Price> {

	/**
	 * this contains the price of an item
	 */
	private BigDecimal price;
	/**
	 * this contains the effectivedate of an item
	 */
	private LocalDate effectiveDate;
	/**
	 * this contains the item, the price class needs to know about the item
	 */
	private Item item;

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * this is an empty constructor of the price class
	 */
	public Price() {
		
		this.price = new BigDecimal(0);
		
	}

	/**
	 * this constructor instantiates the price class and passes it price and effectiveDate as parameters
	 * @param price this is the actual price
	 * @param effectiveDate this is the actual effectiveDate
	 */
	public Price(String price, String effectiveDate) {
		this();
		setPrice(new BigDecimal (price));
		setEffectiveDate(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy")));
	
	}

	/**
	 * this method sets the effective date of a particular price
	 * @param date this is the actual date
	 * @return this method will return a boolean
	 */
	public Boolean isEffective(LocalDate date) {
		
		return this.effectiveDate.isBefore(date) || this.effectiveDate.isEqual(date);
		
	}

	/**
	 * this method calculates the price of a certain amount of quantity of goods
	 * @param quantity this is the actual quantity
	 * @return this method will return a decimal
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		
		return price.multiply(new BigDecimal(quantity));
	}

	/**
	 * this method compares a particular price to another price
	 * @param price this is the actual compared price
	 * @return this method will return an int
	 */
	public int compareTo(Price price) {
		
	 return	this.effectiveDate.compareTo(price.effectiveDate);
		
	}

	/**
	 * this method output what is in the price class to the screen
	 */
	public String toString() {
		return this.price.toString();
	}

	public boolean isPromo()
	{
		return false;
	}

	public void setPrice(String price) {
		
	    this.price=new BigDecimal(price);	
}

	public void setEffectiveDate(String date) {
		
		  this.effectiveDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	}

	


}