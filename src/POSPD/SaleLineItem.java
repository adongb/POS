package POSPD;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * this class contains the details of the different saleLineItems of the store
 */
public class SaleLineItem {

	/**
	 * this is a specific item on the saleLineItem
	 */
	private Item item;
	/**
	 * this is the quantity of the saleLineItem
	 */
	private int quantity;
	/**
	 * this is the sale of the saleLineItem
	 */
	private Sale sale;

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	/**
	 * this is an empty constructor of the SaleLineItem class
	 */
	public SaleLineItem() {
		
		
	}

	/**
	 * this is the constructor that instantiates the SaleLineItem class and passes it the sale, the item and the quantity
	 * @param sale this is the actual sale
	 * @param item this is the actual item
	 * @param string this is the actual quantity
	 */
	public SaleLineItem(Sale sale, Item item, int quantity) {
		this();
		setSale(sale);
		setItem(item);
		setQuantity(quantity);
	}

	/**
	 * this is method calculates the subtTotal of a salelineItem
	 * @return this method will return a decimal
	 */
	public BigDecimal calcSubTotal() {
	
		// calculates the subtotal on a particular saleLineItem
		return this.getItem().calcAmountForDateQty(sale.getDateTime().toLocalDate(), quantity);
	}
	
	/**
	 * this method calculates the tax of the saleLineItem
	 * @return this method will return a decimal
	 */
	public BigDecimal calcTax() {
		
		// calculates the tax for all the items purchased
		return this.getItem().getTaxRateforDate(LocalDate.now()).getTaxRate().multiply(calcSubTotal()).setScale(2,RoundingMode.HALF_DOWN);
	}
	
	/**
	 * this method outputs what's stored in SaleLineItem class to the screen
	 * @return this method will return a string
	 */
	public String toString() {
		return item.UPCsToString()  + " " + item.getDescription() + " " + getQuantity() + " "+"@$"+ getItem().getPriceForDate(LocalDate.now()).getPrice()+" "+ LocalDateTime.now()+ " " + "$" + calcSubTotal();
	}

}