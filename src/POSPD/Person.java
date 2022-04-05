
package POSPD;
/**
 * this class contains all the details of a person
 */
public class Person {

	/**
	 * this is the name of the person
	 */
	private String name;
	/**
	 * this is the address of the person
	 */
	private String address;
	/**
	 * this is the city where the particular person stays in
	 */
	private String city;
	/**
	 * this is the state the particular person stay in
	 */
	private String state;
	/**
	 * this is the zip code of the particular person
	 */
	private String zip;
	/**
	 * this is the phone number of the particular person
	 */
	private String phone;
	/**
	 * this is the social security number of the particular person
	 */
	private String ssn;
	/**
	 * this is the cashier at which the particular is at
	 */
	private Cashier cashier;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Cashier getCashier() {
		return this.cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	/**
	 * this is an empty constructor of the person class
	 */
	public Person() {
		
		
	}

	/**
	 * this is the constructor that instantiates the person class and is passed the name and address of the person
	 * @param name this is the actual name of person
	 * @param address this is the actual address of the person
	 */
	public Person(String name, String address) {
		
		this();
		setName(name);
		setAddress(address);
			
	}

	/**
	 * this method will output what is contained in the person class on the screen
	 * @return this method returns a string
	 */
	public String toString() {
		return this.name.toString();
	}

}