package POSPD;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This class contains the number of the register as well as the cash drawer for the register
 */
public class Register {

	/**
	 * this attribute will record the number of the register
	 */
	private String number;
	/**
	 * this attribute will record the cash drawer for a given register
	 */
	private CashDrawer cashDrawer;
	private ArrayList<Session> sessions;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CashDrawer getCashDrawer() {
		return this.cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}
	
	/**
	 * this is an empty constructor for the register class
	 */
	public Register() {
		sessions = new ArrayList<Session>();
		cashDrawer= new CashDrawer(new BigDecimal("0.00"),0);
	}

	/**
	 * this constructor will initiate the register and it will be passed the number of the register as the parameter
	 * @param number this is the number of the register
	 */
	public Register(String number) {
		this();
		setNumber(number);
		
	}
	
	public  void addSession(Session session)
    {
    	sessions.add(session);
    }

	/**
	 * this will be used to output on the screen what's in Register class
	 * @return a string of characters will be printed
	 */
	public String toString() {
		return this.number.toString();
		
	}
	public  ArrayList<Session> getSessions()
	{
		return sessions;
	}

	public boolean IsRegisterUsed() {
		boolean status = false;
    	if(!this.getSessions().isEmpty())
    	{
    		status=true;
    	}
    	return status;
		
	}

}