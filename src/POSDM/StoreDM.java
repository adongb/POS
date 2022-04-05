package POSDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import POSPD.*;



public class StoreDM {

 public static void loadData(Store store) {
	 
	 Session session = new Session();
	 Sale sale = new Sale();
	 
	 String fileName = "StoreData_v2020.csv";
	 String line = null;
	 String dataType;
	 
	 try {
		 
		 // FileReader reads text files in the default encoding.
		 
		 FileReader fileReader = new FileReader(fileName);
		 
		 // Always wrap FileReader in BufferedReader.
		 
		 BufferedReader bufferedReader = new BufferedReader(fileReader);
		 
		 while ((line = bufferedReader.readLine()) != null)
			 
		 {
			 String [] cols = line.split(",");
			 
			 switch(cols[0]) {
			 
			 case ("Store"): 
				store.setName(cols[1]); 
			 break;
				
			 case ("TaxCategory"):
				 
			 TaxCategory tax1 = new TaxCategory (cols[1], cols[3], cols[2]);
			 store.addTaxCategory(tax1);
			 
			 break;
			 
			 case ("Cashier"):
				 Person person1 = new Person(cols[2], cols[4]);
				 Cashier cashier1 = new Cashier(cols[1],person1,cols[9]);
				 store.addCashier(cashier1);
				 break;
				 
			 case ("Item"):
				 Item item1 = new Item(cols[1], cols[3]);
				 Price price1 = new Price(cols[5], cols[6]);
				 
				 // will pick up promoprice when it's there
				 if (cols.length > 7 ) {
				 PromoPrice promoprice = new PromoPrice(cols[7], cols[8], cols[9]); 
				 item1.addPrice(promoprice);
				 }
				 
				 
				 UPC upc1 = new UPC(cols[2]);				 
				 upc1.setItem(item1);
				 item1.addPrice(price1);
				 item1.addUPC(upc1);
				 item1.setTaxCategory(store.findTaxCategorybyName(cols[4]));
				 store.addItem(item1);
				 store.addUPC(upc1);
				 
			 break;
			 
			 
			 case ("Register"):
				
				Register register2 = new Register(cols[1]);
			 	 store.addRegister(register2);
				
			 break;
			 
			 case ("Session"):
				 
				 session = new Session(store.findCashierForNumber(cols[1]), store.findRegisterbyNumber(cols[2]));
				 store.addSession(session);
				 
			 break;
			 
			 case ("Sale"):
				 if (cols[1].equals("Y")) {
				 sale = new Sale(true);
				 
				 }
			 
				 else
					 sale = new Sale(false);
				 session.addSale(sale);
			 break;
			 
			 
			 case ("SaleLineItem"):
				 
				 SaleLineItem sli1 = new SaleLineItem(sale, store.findItemForNumber(cols[1]) , Integer.parseInt(cols[2]));
				 sale.addSaleLineItems(sli1);
			 break;
			 
			 
			 case ("Payment"):
				 
				 if (cols[1].equals("Credit")) {
					 
					 Credit credit = new Credit(cols[4],cols[5],cols[6], cols[2],cols[3]);
					 BigDecimal amount = new BigDecimal(cols[2]); // converts a string of decimal entered by the user into a decimal number
					 credit.setAmount(amount);
					 BigDecimal amount2 = new BigDecimal(cols[3]);
					 credit.setAmtTendered(amount2);	// converts a string of decimal entered by the user into a decimal number
					 sale.addPayment(credit);
					 
				 }
				 else if (cols[1].equals("Cash")) {
					 
					 Cash cash = new Cash (cols[2],cols[3]);
					 BigDecimal amount = new BigDecimal(cols[2]); // converts a string of decimal entered by the user into a decimal number
					 cash.setAmount(amount);
					 BigDecimal amount2 = new BigDecimal(cols[3]); // converts a string of decimal entered by the user into a decimal number
					 cash.setAmtTendered(amount2);
					 sale.addPayment(cash);
				 }
				 else if (cols[1].equals("Check")) {
					 
					 Check check = new Check();
					 BigDecimal amount = new BigDecimal(cols[2]); // converts the string entered by the user to a big decimal
					 check.setAmount(amount);
					 BigDecimal amount2 = new BigDecimal(cols[3]); // converts the string entered by the user to a big decimal
					 check.setAmtTendered(amount2);
					 sale.addPayment(check);
				 }
				 
			 break;
				 
			 
			 }
			 
			 
		 }
		 
		 // Always close files.
		 bufferedReader.close();
	 } 
		catch (FileNotFoundException ex) {
			
			System.out.println("Unable to open file '" + fileName + "'");
			
		} 
	 	catch (IOException ex) {
	 		
	 		System.out.println("Error reading file '" + fileName + "'");
	 	}	 
	
 }
		
	
}
