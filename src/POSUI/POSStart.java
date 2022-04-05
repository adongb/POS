package POSUI;
import POSDM.StoreDM;
import POSPD.*;
import POSTest.StoreTest;
public class POSStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		Store store = new Store();	
		StoreDM.loadData(store);
		StoreTest.storePrint(store);
		
		POSFrame.open(store);
		
		
		
		
	}

}
