package POSPD;

/**
 * This class will have the details of the Universal Product Code of an item
 */
public class UPC {

	/**
	 * this is the upc of the item
	 */
	private String upc;
	/**
	 * this is the item for which the upc is set
	 */
	private Item item;

	public String getUpc() {
		return this.upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * this is an empty constructor of the UPC class
	 */
	public UPC() {
		
	}

	/**
	 * this constructor instantiates the UPC class and passes it the a particular upc
	 * @param upc this is the actual upc
	 */
	public UPC(String upc) {
		this();
		setUpc(upc);
	}

	/**
	 * this method outputs what is contained in the UPC class to the screen
	 */
	public String toString() {
		return upc;
	}

}