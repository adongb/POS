package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * this class contains all the details of the TaxRate class
 */
public class TaxRate implements Comparable<TaxRate>{

	/**
	 * this is the taxRate
	 */
	private BigDecimal taxRate;
	/**
	 * this is the effectiveDate
	 */
	private LocalDate effectiveDate;

	public BigDecimal getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * this is an empty constructor of the TaxRate class
	 */
	public TaxRate() {
		
	}

	/**
	 * this constructor instantiates the TaxRate class and passes it the effectiveDate and the rate
	 * @param effectiveDate this is the actual effectiveDate of the taxRate
	 * @param rate this is the actual rate that is set
	 */
	public TaxRate(String effectiveDate, String rate) {
		
		setEffectiveDate(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy")));
		setTaxRate(new BigDecimal(rate));
	}

	/**
	 * this method checks and determines whether the effectiveDate is the LocalDate
	 * @param date this is the actual date used by the isEffective method
	 * @return this method returns a boolean
	 */
	public boolean isEffective(LocalDate date) {
		
		return this.effectiveDate.isBefore(date) || this.effectiveDate.isEqual(date);
		
	}

	/**
	 * this method compares the taxRates
	 * @param taxRate this is the actual TaxRate used to compare
	 * @return this method returns an integer
	 */
	public int compareTo(TaxRate taxRate) {
		
		 return	this.effectiveDate.compareTo(taxRate.effectiveDate);
	}

	/**
	 * this method outputs what is contained in the taxRate class to the screen
	 * @return this method returns a string
	 */
	public String toString() {
		return taxRate.toString();
	}

	public void setTaxRate(String taxRate) {
		this.taxRate =new BigDecimal(taxRate);
	}

	public void setEffectiveDate(String date) {
		this.effectiveDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	

}