package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * this class contains all the details of the TaxCategory class
 */
public class TaxCategory {

	/**
	 * this is the category in which a particular tax is put
	 */
	private String category;
	/**
	 * this is the taxRate
	 */
	private TreeSet<TaxRate> taxRates;

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public TreeSet<TaxRate> getTaxRates() {
		return this.taxRates;
	}

//	public void setTaxRates(Collection<TaxRate> taxRates) {
//		this.taxRates = taxRates;
//	}

	/**
	 * this is an empty constructor of the taxCategory class
	 */
	public TaxCategory() {
		taxRates = new TreeSet<TaxRate>();
	}

	/**
	 * this constructor instantiates the taxCategory class
	 * @param category
	 * @param effectiveDate
	 * @param taxRate
	 */
	public TaxCategory(String category, String effectiveDate, String taxRate) {
		this();
		setCategory(category);
		TaxRate tax1 = new TaxRate(effectiveDate, taxRate);
		addTaxRate(tax1);
		
	}

	/**
	 * this method will get the tax rate of a specific date
	 * @param date
	 * @return this method returns a decimal
	 */
	public TaxRate getTaxRateforDate(LocalDate date) {

		for (TaxRate taxRate : getTaxRates()) {
			
			if (taxRate.isEffective(date)) 
				
				return taxRate;

		}
		 return null; // for when there no effective taxRate
	}

	/**
	 * this method adds a specific taxRate to the TaxCategory class
	 * @param taxRate this is the actual taxRate
	 */
	public void addTaxRate(TaxRate taxRate) {
		getTaxRates().add(taxRate);
}

	/**
	 * this method is used to output what is kept in the TaxCategory class to the screen
	 * @return this method returns a string
	 */
	public String toString() {
		return category;
	}

	/**
	 * this method will remove a specific tax Rate from a certain TaxCategory class
	 * @param taxRate this is the actual removed taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		getTaxRates().remove(taxRate);
	}

}