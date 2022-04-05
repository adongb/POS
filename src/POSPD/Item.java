package POSPD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * This class contains the details for each individual item
 */
public class Item {

	/**
	 * this is the item number
	 */
	private String number;
	/**
	 * this is the item description
	 */
	private String description;
	/**
	 * this represents the saleLineItem postion of the particular item
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * this will contain the upc number of the particular item
	 */
	private TreeMap<String, UPC> uPCs;
	/**
	 * this attribute keeps the particular price for an item
	 */
	private TreeSet<Price> prices;
	/**
	 * this will categorize a particular item in a taxCategory
	 */
	private TaxCategory taxCategory;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

//	public void setSaleLineItems(TreeMap<String, SaleLineItem> saleLineItems) {
//		this.saleLineItems = saleLineItems;
//	}

	public TreeMap<String,UPC> getUPCs() {
		return this.uPCs;
	}

//	public void setUPCs(Collection<UPC> uPCs) {
//		this.uPCs = uPCs;
//	}

	public TreeSet<Price> getPrices() {
		return this.prices;
	}

//	public void setPrices(Collection<Price> prices) {
//		this.prices = prices;
//	}

	public TaxCategory getTaxCategory() {
		return this.taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}

	/**
	 * this is an empty item class constructor
	 */
	public Item() {
		
		saleLineItems = new ArrayList<SaleLineItem>();
		uPCs = new TreeMap<String, UPC>();
		prices = new TreeSet<Price>();
		
	}

	/**
	 * this constructor instantiates the Item class and passes it number and description of the item
	 * @param number this is the actual number of the item
	 * @param description this is the actual description of the item
	 */
	public Item(String number, String description) {
		this();
		setNumber(number);
		setDescription(description);
	}
	
	
	/**
	 * this method will add the price of the item
	 * @param price this is the actual price added to the item
	 */
	public void addPrice(Price price) {
		getPrices().add(price);
	}

	/**
	 * this method will remove the price of a particular item
	 * @param price this is the actual price removed
	 */
	public void removePrice(Price price) {
		getPrices().remove(price);
	}

	/**
	 * this method will add the upc for a particular item
	 * @param upc this is the actual added UPC
	 */
	public void addUPC(UPC upc) {
		
		getUPCs().put(upc.getUpc(), upc);
		
	}

	/**
	 * this method will remove the UPC of a particular item
	 * @param upc this is the actual removed UPC
	 */
	public void removeUPC(UPC upc) {
		getUPCs().remove(upc.getUpc());
	}
	
	public void addSli(SaleLineItem Sli)
	{
		this.saleLineItems.add(Sli);
	}

	/**
	 * this method will get the price of an item for a specific date
	 * @param date this is the actual price gotten for a given date
	 * @return a price will be returned by this method
	 */
	public Price getPriceForDate(LocalDate date) {
		
		Price remember = null;
		
		for (Price price : this.prices) {
			
			if (price.isEffective(date)) 
				
			 remember = price;
				

		}
		 return remember; 
	}

	/**
	 * this method will get the tax rate of a particular item for a given date
	 * @param date this is the actual tax rate gotten for a specific date of a specific item
	 * @return a decimal number will be returned by this method
	 */
	public TaxRate getTaxRateforDate(LocalDate date) {

		return this.taxCategory.getTaxRateforDate(date);
	}

	/**
	 * this method will calculate the amount for a given date quantity of an item
	 * @param date this is the actual date for the amount of the item to be calculated
	 * @param quantity this is the actual quantity of the item of which the amount is going to be calculated
	 * @return a decimal will be returned by this method
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) {
		
		Price price = getPriceForDate(date);
		
		return price.calcAmountForQty(quantity);
		
		
		
	}

	/**
	 * this function changes the collection of UPCs to a string
	 * @return String representation of UPCs
	 */
	
	public String UPCsToString() {
		
		String temp = "";
		
		for (UPC upc : getUPCs().values()) {
			
			temp += upc.toString();
			
		}
		
		return temp;
	}
	
	public int  soldCount(LocalDate date)
	{
		
		int count=0;
		if(!getSaleLineItems().isEmpty())
		{
			for(SaleLineItem sli:getSaleLineItems())
		    {
			    if(sli.getSale().getDateTime().toLocalDate().isBefore(date)||sli.getSale().getDateTime().toLocalDate().isEqual(date))
			        count+=sli.getQuantity();
		     }
		}
		return count;
	}
	
	/**
	 * this method will be used to output to the screen
	 * @return a string will be returned by this method
	 */
	public String toString() {
		
		return UPCsToString()  + " " + getDescription() + " " + this.getPriceForDate(LocalDate.now()) + " " + this.getTaxRateforDate(LocalDate.now()) ;
	}

	

}