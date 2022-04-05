package POSTest;
import java.time.LocalDate;
import java.time.LocalDateTime;

import POSDM.StoreDM;
import POSPD.*;

public class StoreTest {

	public static void storeTest(Store store) {
	
		StoreDM.loadData(store);
		
//		store.setName("Ado's Store");
//		store.setNumber("1");
//		
//		TaxCategory tax1 = new TaxCategory ("Food", "8/28/07", "0.07");
//		Item item1 = new Item("1", "Turkey Sandwich");
//		Price price = new Price("2.29", "1/1/20");
//		UPC upc1 = new UPC("1001");
//		Register register1 = new Register("1");
//		store.addRegister(register1);
//		upc1.setItem(item1);
//		item1.setTaxCategory(tax1);
//		item1.addPrice(price);
//		item1.addUPC(upc1);
//		store.addItem(item1);
//		
//		
//		TaxCategory tax2 = new TaxCategory ("Food", "8/30/07", "0.07");
//		Item item2 = new Item("2", "Ham Sandwich");
//		Price price2 = new Price("2.59", "1/1/20");
//		UPC upc2 = new UPC("1002");
//		Register register2 = new Register("2");
//		store.addRegister(register2);
//		upc2.setItem(item2);
//		item2.setTaxCategory(tax2);
//		item2.addPrice(price2);
//		item2.addUPC(upc2);
//		store.addItem(item2);
//		
//		
//		TaxCategory tax3 = new TaxCategory ("Drinks", "8/27/07", "0.00");
//		Item item3 = new Item("3", "Coke");
//		Price price3 = new Price("0.97", "1/1/20");
//		UPC upc3 = new UPC("1003");
//		upc3.setItem(item3);
//		item3.setTaxCategory(tax3);
//		item3.addPrice(price3);
//		item3.addUPC(upc3);
//		store.addItem(item3);
//		
//		
//		TaxCategory tax4 = new TaxCategory ("Drinks", "8/23/07", "0.00");
//		Item item4 = new Item("4", "Dr. Pepper");
//		Price price4 = new Price("0.79", "1/1/20");
//		UPC upc4 = new UPC("1004");
//		upc4.setItem(item4);
//		item4.setTaxCategory(tax4);
//		item4.addPrice(price4);
//		item4.addUPC(upc4);
//		store.addItem(item4);
//		
//		
//		Person person1 = new Person("David", "2501 E Memorial Rd");
//		Person person2 = new Person("Sally", "2801 E Memorial Rd");
//		Person person3 = new Person("Ado", "2901 E Memorial Rd");
//		
//		
//		Cashier cashier1 = new Cashier("1",person1,"let's go");
//		Cashier cashier2 = new Cashier("2",person2,"what up");
//		Cashier cashier3 = new Cashier("3",person3,"what's good");
//		
//		store.addCashier(cashier1);
//		store.addCashier(cashier2);
//		store.addCashier(cashier3);
//		
//		//Creates a new session
//		Session session = new Session(cashier1, register1);
//		
//		
//		//First sale
//		Sale sale = new Sale(true);
//		
//		//Creates  Sale Line Items
//		SaleLineItem sli1 = new SaleLineItem(sale, item1, 1);
//		SaleLineItem sli2 = new SaleLineItem(sale, item2, 2);
//		
//		session.addSale(sale);
//		 
//		store.addSession(session);
//		sale.addSaleLineItems(sli1);
//		sale.addSaleLineItems(sli2);
		
		
		
	}
	
	public static void storePrint(Store store) {
		
		System.out.println("Ready to open Store");
		System.out.println("\nAdo's Quick Mart");
		
		System.out.println("===============================");
		
		System.out.println("Cashiers");
		
		System.out.println("===============================");
		
		for (Cashier cashier: store.getCashiers().values()) {
			
			System.out.println(cashier);
		}
		
		System.out.println("===============================");
		
		System.out.println("Registers");
		
		System.out.println("===============================");
		
		for (Register register: store.getRegisters().values()) {
			
			System.out.println(register);
			
		}
		
		System.out.println("===============================");
		
		System.out.println("Items");
		
		
		System.out.println("===============================");
		
		for(Item item: store.getItems().values()) {
			
			
			System.out.println(item);
			
		}
		
		System.out.println("===============================");
		
		System.out.println("Sessions");
		
		System.out.println("===============================");
		
		for(Session session: store.getSessions()) {
			
			System.out.println("Session : Cashier : " + session.getCashier().getPerson().getName() + " Register : " + session.getRegister().getNumber() + " Date: " + LocalDateTime.now() +" Total: " + session.calculateTotal());
		
		for (Sale sale: session.getSales()) {
			
			System.out.println("\nSale: SubTotal =  " + sale.calcSubTotal() + " Tax = " + sale.calcTax() + " Total = " + sale.calcTotal() + " Payment = " + sale.getTotalPayments() + " Change = " + sale.calcChange());
			
		for (SaleLineItem saleLineItem: sale.getSaleLineItems()) {
			
			System.out.println(saleLineItem);
			
			}
		}	
		
		}
		
		System.out.println("\nStore Open: Ado's Quick Mart");
		
	}
}
