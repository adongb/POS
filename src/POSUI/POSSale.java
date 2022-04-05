package POSUI;

import javax.swing.JFrame;

import javax.swing.JPanel;

import POSPD.*;
import POSTest.StoreTest;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * 
 *
 */
public class POSSale extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	public static DefaultListModel listModel;
	private static JButton btnPayment;
	private String quantity;
	private SaleLineItem currentSli;
	private Sale currentSale;
	private static JButton btnNewButton;
	private static JButton btnEndSession;
	/**
	 * Create the sale panel.
	 */
    public POSSale(final JFrame currentFrame, final Store store,final Sale sale,final Session session) {
		setLayout(null);

		//Sale sale = new Sale();
		// = new SaleLineItem();
		final JPanel currentPanel =this;
		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(30, 113, 242, 16);
		add(lblNewLabel);
		
		 currentSale= sale;
      
     	listModel = new DefaultListModel();
     	
		JLabel lblCashier = new JLabel("Cashier:");
		lblCashier.setBounds(12, 13, 56, 16);
		add(lblCashier);

		JLabel label = new JLabel(session.getCashier().toString());
		label.setBounds(68, 13, 93, 16);
		add(label);

		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setBounds(12, 42, 56, 16);
		add(lblRegister);

		JLabel label_1 = new JLabel(session.getRegister().toString());
		label_1.setBounds(68, 42, 56, 16);
		add(label_1);

		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(20, 84, 56, 16);
		add(lblItem);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(store.findUPC(textField.getText())!= null)
				{
					lblNewLabel.setText("");
					UPC upc = store.findUPC(textField.getText());
				    Item item = upc.getItem();
				    if(item!=null)
				    {
				       SaleLineItem sli = new SaleLineItem(currentSale,item,Integer.parseInt(textField_1.getText()));
			        	currentSli=sli;
				        item.addSli(sli);
				        listModel.addElement(sli);
				        currentSale.addSaleLineItem(sli);
				        updateFields(currentSale);
				     }
				}
				else
					lblNewLabel.setText("Error! UPC not Found.");
				
				
			}
		});
		textField.setBounds(68, 81, 116, 22);
		add(textField);
		textField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(206, 84, 67, 16);
		add(lblQuantity);

		textField_1 = new JTextField("1");
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantity = textField_1.getText();
				listModel.removeElement(currentSli);
				listModel.addElement(currentSli);
				currentSli.setQuantity(Integer.parseInt(quantity));
				updateFields(currentSale);
			}
		});
		textField_1.setBounds(269, 81, 56, 22);
		add(textField_1);
		textField_1.setColumns(10);

		final JCheckBox chckbxTaxFree = new JCheckBox("Tax Free");
		chckbxTaxFree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxTaxFree.isSelected())
				{
					currentSale.setTaxFree(true);
					updateFields(currentSale);
				}
				else
				{
					currentSale.setTaxFree(false);
					updateFields(currentSale);
				}
			}
		});
		chckbxTaxFree.setBounds(348, 38, 113, 25);
		add(chckbxTaxFree);
		// SaleLineItem
		// JList list = new JList();

		JList<Item> list = new JList<Item>(listModel);
		list.setBounds(32, 130, 255, 77);
		add(list);

		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setBounds(299, 131, 56, 16);
		add(lblSubtotal);

		textField_2 = new JTextField(sale.calcSubTotal().toString());
		textField_2.setBounds(367, 128, 56, 22);
		add(textField_2);
		textField_2.setColumns(10);
        textField_2.setEnabled(false);
		JLabel lblTax = new JLabel("Tax:");
		lblTax.setBounds(299, 160, 56, 16);
		add(lblTax);

		textField_3 = new JTextField(sale.calcTax().toString());
		textField_3.setBounds(365, 157, 58, 22);
		add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(299, 191, 56, 16);
		add(lblTotal);

		textField_4 = new JTextField(sale.calcTotal().toString());
		textField_4.setBounds(367, 185, 58, 22);
		add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEnabled(false);
		JLabel lblAmttendered = new JLabel("AmtTendered:");
		lblAmttendered.setBounds(269, 225, 86, 16);
		add(lblAmttendered);

		textField_5 = new JTextField(sale.calcAmtTendered().toString());
		textField_5.setBounds(367, 222, 71, 22);
		add(textField_5);
		textField_5.setColumns(10);
		textField_5.setEnabled(false);
		JLabel lblChange = new JLabel("Change:");
		lblChange.setBounds(269, 260, 56, 16);
		add(lblChange);

		textField_6 = new JTextField(sale.calcChange().toString());
		textField_6.setBounds(367, 257, 71, 22);
		add(textField_6);
		textField_6.setColumns(10);
		textField_6.setEnabled(false);
	    btnPayment = new JButton("Payment");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentPanel, currentFrame,currentSale,session,store));
				 currentFrame.getContentPane().revalidate();

			}
		});
		btnPayment.setBounds(12, 220, 87, 25);
		add(btnPayment);
		if(sale.calcSubTotal().equals(new BigDecimal("0.00")))
			btnPayment.setEnabled(false);
        
		JButton btnCancelSale = new JButton("Cancel Sale");
		btnCancelSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//session.removeSale(sale);
			listModel.clear();
			currentSale = new Sale();
			updateFields(currentSale);
			textField.setText("");
			textField_1.setText("");
			}
		});
		btnCancelSale.setBounds(12, 256, 112, 25);
		add(btnCancelSale);

		btnEndSession = new JButton("End Session");
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashDiff(currentFrame,store,session));
				currentFrame.getContentPane().revalidate();
				//Test.storeTest(store);
			}
		});
		btnEndSession.setBounds(135, 256, 113, 25);
		add(btnEndSession);
		btnEndSession.setEnabled(false);
		
		btnNewButton = new JButton("Complete Sale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.addSale(sale);
				currentSale=new Sale();
				listModel.clear();
				currentSale = new Sale();
				updateFields(currentSale);
				textField.setText("");
				textField_1.setText("");
				btnEndSession.setEnabled(true);
			}
		});
		btnNewButton.setBounds(127, 220, 121, 25);
		add(btnNewButton);
			
		
		
		

	}
    public static void updateFields(Sale sale)
    {
    	textField_2.setText(sale.calcSubTotal().toString());
		textField_4.setText(sale.calcTotal().toString());
		textField_3.setText(sale.calcTax().toString());
		textField_5.setText(sale.calcAmtTendered().toString());
		
		if(sale.calcSubTotal().equals(new BigDecimal("0.00")))
			btnPayment.setEnabled(false);
		else 
			btnPayment.setEnabled(true);
	
		if(sale.calcChange().compareTo(new BigDecimal("0"))==-1)
		{
			textField_6.setText("0.00");
			btnNewButton.setEnabled(false);
			btnEndSession.setEnabled(false);
		}
		else 
		{
			textField_6.setText(sale.calcChange().toString());
			
			btnNewButton.setEnabled(true);
		}
    }
}
