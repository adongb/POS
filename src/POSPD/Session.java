package POSPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This class will record the details of every single session created
 */
public class Session {

	/**
	 * this contains the information of the register
	 */
	private Register register;
	/**
	 * this will keep record the start date time of the session
	 */
	private LocalDateTime startDateTime;
	/**
	 * this will record the end date time of the session
	 */
	private LocalDateTime endDateTime;
	/**
	 * this will record the the sales made during a specific session
	 */
	private ArrayList<Sale> sales;
	/**
	 * this will record the details of the cashier who started a specific session
	 */
	private Cashier cashier;

	public Register getRegister() {
		return this.register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return LocalDateTime.now();
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public ArrayList<Sale> getSales() {
		return this.sales;
	}

//	public void setSales(ArrayList<Sale> sales) {
//		this.sales = sales;
//	}

	public Cashier getCashier() {
		return this.cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	/**
	 * Empty constructor
	 */
	public Session() {
		
		sales = new ArrayList<Sale>();
		
	}

	/**
	 * Constructor for the class session, this will be passed the cashier and register
	 * @param cashier this is the actual cashier in a specific session
	 * @param register
	 */
	
	public Session(Cashier cashier, Register register) {
		this();
		setCashier(cashier);
		setRegister(register);
		setStartDateTime(LocalDateTime.now());
	}
	
	/**
	 * this method adds the sale made during the a specific session
	 * @param sale
	 */
	public void addSale(Sale sale) {
		getSales().add(sale);
	}

	/**
	 * this method removes the sale of an item during a specific session
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		getSales().remove(sale);
	}
	
	public BigDecimal SalesTotal()
	{
		BigDecimal amt = new BigDecimal("0");
		if(!sales.isEmpty())
		{
			for(Sale sale:sales)
			{
				amt=amt.add(sale.calcTotal());
			}
		}
		return amt.setScale(2,RoundingMode.HALF_UP);
	}

	/**
	 * this method will perform the arithmetic of finding the difference to be given back to the customer when they pay using cash
	 * @param cash this is the actual calculated cash
	 * @return this will be the returned cash count and we're giving it as much space as possible.
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
		return cash.subtract(getRegister().getCashDrawer().getCashAmount());
	}
	
	public BigDecimal calculateTotal() {
		

		BigDecimal sessionTotal = new BigDecimal(0);
		
		for (Sale sale: getSales()) {
			
			sessionTotal = sessionTotal.add(sale.calcTotal());
			
		}
		
		return sessionTotal;
		
	}
	
	/**
	 * this method will output the details of the Session class
	 * @return the output returned will be a string of characters
	 */
	public String toString() {
		
		return "Session : Cashier :" + getCashier().getPerson().getName() + " Register :" + getRegister().getNumber() +" Date : " + getStartDateTime() + " Total : " + calculateTotal();
		
	}

}