package POSPD;

import java.util.*;


import POSDM.StoreDM;

/**
 * This class contains every single detail what's kept in store.
 */
public class Store {

	/**
	 * This is the number of the specific store
	 */
	private String number;
	/**
	 * This contains the name of the Store
	 */
	private String name;
	/**
	 * This contains the different tax categories of the items in the store
	 */
	private TreeMap<String, TaxCategory> taxCategories;
	/**
	 * This contains the different details of a particular login session start, end, sales made, and the particular cashier
	 */
	private ArrayList<Session> sessions;
	/**
	 * This attribute represents all the different upcs in the store
	 */
	private TreeMap<String, UPC> upcs;
	/**
	 * This attribute represents all the different cashiers in the store
	 */
	private TreeMap<String, Cashier> cashiers;
	/**
	 * This attribute represents all the different items in the store.
	 */
	private TreeMap<String, Item> items;
	/**
	 * This attribute represents all the different registers in the store and their specific details
	 */
	private TreeMap<String, Register> registers;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeMap<String, TaxCategory> getTaxCategories() {
		return this.taxCategories;
	}


	public ArrayList<Session> getSessions() {
		return this.sessions;
	}


	public TreeMap<String, UPC> getUpcs() {
		return this.upcs;
	}

	
	public TreeMap<String, Cashier> getCashiers() {
		return this.cashiers;
	}


	public TreeMap<String, Item> getItems() {
		return this.items;
	}


	public TreeMap<String, Register> getRegisters() {
		return this.registers;
	}

	/**
	 * This is an empty constructor
	 */
	public Store() {
		taxCategories = new TreeMap<String, TaxCategory>();
		sessions = new ArrayList<Session>();
		cashiers = new TreeMap<String, Cashier>();
		upcs = new TreeMap<String, UPC>();
		items = new TreeMap<String, Item>();
		registers = new TreeMap<String, Register>();
	}
	

	/**
	 * This is the constructor for the Store class, it has number and name of type string passed to it
	 * @param number this is the store number
	 * @param name this is the name of the store
	 */
	public Store(String number, String name) {
		this();
		setNumber(number);
		setName(name);
	}

	/**
	 * This method identifies an item
	 * @param upc this is the actual UPC
	 * @return This returns the item found
	 */
	public Item findItemForUPC(String upc) {
		return getItems().get(upc);
		
	}

	/**
	 * this method will find a cashier using a given number
	 * @param number this is the actual cashier number
	 * @return this will return the found cashier given a specific number
	 */
	public Cashier findCashierForNumber(String number) {
		return getCashiers().get(number);
	}

	/**
	 * this method will add an item to the store class
	 * @param item this is the actual added item
	 */
	public void addItem(Item item) {
		getItems().put(item.getNumber(), item);
	}
	/**
	 * this method will add a UPC to the store
	 * @param upc this is the actual added UPC
	 */
	public void addUPC(UPC upc) {
		getUpcs().put(upc.getUpc(), upc);
	}

	/**
	 * this method will add a register to the store class
	 * @param register this is the actual added register
	 */
	public void addRegister(Register register) {
		getRegisters().put(register.getNumber(), register);
	}

	/**
	 * this method will add a cashier to the store class
	 * @param cashier this is the actual added cashier
	 */
	public void addCashier(Cashier cashier) {
		getCashiers().put(cashier.getNumber(), cashier);
		
	}

	/**
	 * this method will remove a specific item out of the store class
	 * @param item this is the actual removed item
	 */
	public void removeItem(Item item) {
		getItems().remove(item.getNumber(), item);
	}

	/**
	 * this method will remove a UPC out of the Store class
	 * @param upc this is the actual removed UPC
	 */
	public void removeUPC(UPC upc) {
		getUpcs().remove(upc);
	}

	/**
	 * this will remove a specific register from the Store class
	 * @param register this is the actual removed register
	 */
	public void removeRegister(Register register) {
		getRegisters().remove(register.getNumber());
	}

	/**
	 * this will remove a specific cashier from the Store class
	 * @param cashier this is the actual removed cashier
	 */
	public void removeCashier(Cashier cashier) {
		getCashiers().remove(cashier.getNumber());
	}

	/**
	 * this will add a specific Tax Category to the store class
	 * @param taxCategory this is the actual added tax category
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		getTaxCategories().put(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * this will remove a specific tax category from the store class
	 * @param taxCategory this is the actual removed tax category
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		getTaxCategories().remove(taxCategory.getCategory());
	}

	/**
	 * this method will add a session to the Store class
	 * @param session this is the actual added session
	 */
	public void addSession(Session session) {
		getSessions().add(session);
	}

	/**
	 * this method will remove the user session from the Store class
	 * @param session this is the actual removed session
	 */
	public void removeSession(Session session) {
		getSessions().remove(session);
	}

	/**
	 * this method will use a given number to find a register
	 * @param number this is the actual number of the found register
	 * @return This is register that will be returned after it is found
	 */
	public Register findRegisterbyNumber(String number) {
		return getRegisters().get(number);
	}

	/**
	 * this method will find a specific item when given a specific number
	 * @param number this is the actual number of the item
	 * @return this will be the returned item when found using a specific number
	 */
	public Item findItemForNumber(String number) {
		return getItems().get(number);
	}

	/**
	 * this method will use a given name to find the tax category of an item
	 * @param category this is the actual tax category name
	 * @return this will return the found tax category
	 */
	public TaxCategory findTaxCategorybyName(String category) {
		return getTaxCategories().get(category);
	}

	/**
	 * this method will output a string of characters
	 * @return this will be the returned string from what has been entered by the user
	 */
	
	/*
	 * This method opens the store
	 */
	
	public void open() {
		
		StoreDM.loadData(this); // passes the object we're in. hence for this case, "this" means the Store class.
		
	}
	
	public String toString() {
		// TODO - implement Store.toString
		throw new UnsupportedOperationException();
	}

	public boolean upcFound(String upc)
	{
		System.out.println(upc);
		boolean isFound=false;
		for(Item item : items.values())
		{	
			
			for(UPC uPC : item.getUPCs().values()) {
			
			if(uPC.getUpc() == upc)
				return true;
			}		// isFound=true;
		}
		return isFound;	
	}

	public UPC findUPC(String upc)
   {
	   return upcs.get(upc);
   }

}