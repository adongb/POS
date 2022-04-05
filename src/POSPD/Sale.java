package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

/**
 * this class will contain all the details of a particular sale.
 */
public class Sale {

	/**
	 * this is the payment for the sale
	 */
	private ArrayList<Payment> payments;
	/**
	 * this is the saleLineItems of a particular sale
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * this is the dateTime of a particular sale
	 */
	private LocalDateTime dateTime;
	/**
	 * this attribute contains details for taxFree items
	 */
	private Boolean taxFree;

	public ArrayList<Payment> getPayments() {
		return this.payments;
	}

//	public void setPayments(Collection<Payment> payments) {
//		this.payments = payments;
//	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

//	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
//		this.saleLineItems = saleLineItems;
//	}

	public LocalDateTime getDateTime() {
		if (this.dateTime == null)
			return LocalDateTime.now();
			
		else
			return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Boolean getTaxFree() {
		return this.taxFree;
	}

	public void setTaxFree(Boolean taxFree) {
		this.taxFree = taxFree;
	}

	/**
	 * this is the empty sale constructor
	 */
	public Sale() {
		
		payments = new ArrayList<Payment>();
		saleLineItems = new ArrayList<SaleLineItem>();
		taxFree = false;
		
	}

	/**
	 * this constructor instantiates the sale class and passes it the taxFree attribute
	 * @param taxFree this is the actual taxfree specification
	 */
	public Sale(Boolean taxFree) {
		this();
		setTaxFree(taxFree);
	}

	/**
	 * this method will add the payment to a particular sale
	 * @param payment this is the actual payment
	 */
	public void addPayment(Payment payment) {
		getPayments().add(payment);
		
	}

	/**
	 * this method will remove the payment from a particular sale
	 * @param payment this is the actual payment removed
	 */
	public void removePayment(Payment payment) {
		getPayments().remove(payment);
	}

	/**
	 * this method will add the saleLineItems to a specific sale
	 * @param sli this is the actual added saleLineItem
	 */
	public void addSaleLineItems(SaleLineItem sli) {
		getSaleLineItems().add(sli);
	}

	/**
	 * this method will remove the saleLineItem from a specific sale
	 * @param payment this is the actual removed saleLineItem
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		getSaleLineItems().remove(sli);
	}

	/**
	 * this method calculates the total of a particular sale
	 * @return this method will return decimal
	 */
	
	/**
	 * this method will calculate the sub total of a particular sale
	 * @return this method will return a decimal
	 */
	public BigDecimal calcSubTotal() {
		
		BigDecimal Total = new BigDecimal(0);
		
		for (SaleLineItem sli: getSaleLineItems()) {
			
			Total = Total.add(sli.calcSubTotal());
	
		}

		return Total;
		
	}

	/**
	 * this method will calculate the tax of a particular sale
	 * @return this method will return a decimal
	 */
	public BigDecimal calcTax() {
		
		if(getTaxFree()) {
			
			return new BigDecimal("0.00");
		}
		
		BigDecimal taxTotal = new BigDecimal(0);
		
		for (SaleLineItem sli: getSaleLineItems()) {
			
			taxTotal = taxTotal.add(sli.calcTax());
			
		}
		
		return taxTotal;
		
	}

	
	public BigDecimal calcTotal() {
		
		return calcTax().add(calcSubTotal());
				
	}

	
	/**
	 * this method gets the total payments of a particular item
	 * @return this method will return a decimal
	 */
	public BigDecimal getTotalPayments() {
		
		BigDecimal total = new BigDecimal(0.00);
		
		for(Payment payment : payments) {
			
			
			total = total.add(payment.getAmount());
			
		}
		return total;
	}

	/**
	 * this method determines whether or not the payment is enough
	 * @return this method will return a boolean(true or false)
	 */
	public Boolean isPaymentEnough() {
		// TODO - implement Sale.isPaymentEnough
		return !(this.getTotalPayments().compareTo(this.calcTotal())==-1);
	}

	/**
	 * this method will calculate the total amount for a particular payment of a sale
	 * @param amtTendered this is the amount payment
	 */
	public BigDecimal calcAmountForPayment(BigDecimal amtTendered) {
		
		BigDecimal amount = calcTotal().subtract(getTotalPayments());
		
		if(amount.compareTo(amtTendered) > 0) {
			
			amount = amtTendered;
		}
		
		return amount;
		
	}
	
	/**
	 * determines if there's an amount left to be paid
	 * @return
	 */
	
	public  BigDecimal remainingPay()
	{
		BigDecimal needed = new BigDecimal("0");
		if(!isPaymentEnough())
		{
			needed = calcTotal().subtract(calcAmtTendered());
		}
		return needed.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * this method will calculate the change for a particular sale
	 * @return this method will return a decimal
	 */
	public BigDecimal calcChange() {
		
		BigDecimal change = calcAmtTendered().subtract(this.calcTotal()); 
		
		return change;
	}

	/**
	 * this method will calculate the amount tendered
	 * @return this method will return a decimal
	 */
	public BigDecimal calcAmtTendered() {
		
		BigDecimal total = new BigDecimal(0.00);
		
		for(Payment payment : payments) {
			
			total = total.add(payment.getAmtTendered());
			
		}
		return total;
		
		
	}

	/**
	 * this method will output to the screen
	 * @return this method will return a string
	 */
	public String toString() {
		return "";
	}

	/**
	 * addSaleLineItem adds a sale line item.
	 * @param sli sli represents a sale line item.
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		if(sli!=null)
			this.saleLineItems.add(sli);
	}

}