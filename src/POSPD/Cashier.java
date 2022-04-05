package POSPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

/**
 * this class contains all the details of the Cashier class
 */
public class Cashier {

	/**
	 * this is the number of a particular cashier
	 */
	private String number;
	/**
	 * this is the particular person at a particular cashier
	 */
	private Person person;
	/**
	 * this is the session of a particular Cashier
	 */
	private ArrayList<Session> sessions;
	/**
	 * this is the password of a given cashier
	 */
	private String password;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ArrayList<Session> getSessions() {
		return this.sessions;
	}

//	public void setSessions(Collection<Session> sessions) {
//		this.sessions = sessions;
	//}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * this is an empty constructor of the Cashier class
	 */
	public Cashier() {
		sessions = new ArrayList<Session>();
	}

	/**
	 * this constructor instantiates the cashier class and passes it the number, person, and password
	 * @param number this is the actual number of the cashier
	 * @param person this is the actual person at the cashier
	 * @param password this is the actual password of a particular cashier
	 */
	public Cashier(String number, Person person, String password) {
		this();
		
		setNumber(number);
		setPerson(person);
		setPassword(password);
		
	}

	/**
	 * this method adds the session to a particular cashier
	 * @param session this is the actual added session
	 */
	public void addSession(Session session) {
		getSessions().add(session);
	}

	/**
	 * this method removes the session from a specific cashier
	 * @param session this is the actual removed cashier
	 */
	public void removeSession(Session session) {
		getSessions().remove(session);
	}

	public BigDecimal TotalSalesforCashier(LocalDate date)
	{
		BigDecimal amt = new BigDecimal("0");
		if(!sessions.isEmpty())
		{
			for(Session session:sessions)
			{
				if(session.getEndDateTime().toLocalDate().isBefore(date)||session.getEndDateTime().toLocalDate().isEqual(date))
				amt=amt.add(session.SalesTotal());
			}
		}
		return amt.setScale(2,RoundingMode.HALF_UP);
	}
	/**
	 * this method outputs what is in the cashier class to the screen
	 * @return this method returns a string
	 */
	public String toString() {
		return this.person.getName();
	}
	/**
	 * this method checks and determines whether the cashier is authorized to login. it uses the password to determine that.
	 * @param password this is the actual password passed in by the person at the cashier and this password is the one used by the isAuthorized method or checking
	 * @return this method returns a boolean
	 */
	public Boolean isAuthorized(String password) {
		return this.password.equals(password);
	}
	
	public int getNumberOfSales(LocalDate date)
	{
		int num=0;
		if(!sessions.isEmpty())
		{
			for(Session session:sessions)
			{
				if(!session.getSales().isEmpty()&&(session.getEndDateTime().toLocalDate().isBefore(date)||session.getEndDateTime().toLocalDate().isEqual(date)))
				   num+=session.getSales().size();
			}
		}
		return num;
	}

}